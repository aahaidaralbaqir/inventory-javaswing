package usecase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;
import dto.CreateItemDTO;
import dto.UpdateItemDTO;
public class Item {
	private Connection conn;
	public Item(Connection conn) {
		this.conn = conn;
	}

	public void create(CreateItemDTO item) throws Exception {
		try {
			PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO `inventaris`.`items` (`code`, `description`, `size`, `article`, `merk`, `sell_price`) VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, item.getCode());
			stmt.setString(2, item.getDescription());
			stmt.setString(3, item.getSize());
			stmt.setString(4, item.getArticle());
			stmt.setString(5, item.getMerk());
			stmt.setInt(6, item.getSellPrice());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public List<ItemModel> list() throws Exception {
		List<ItemModel> items = new ArrayList<>();
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM items");
			while(results.next()) {
				ItemModel item = new ItemModel();
				item.setId(results.getInt("id"));
				item.setCode(results.getString("id"));
				item.setDescription(results.getString("id"));
				item.setSize(results.getString("id"));
				item.setArticle(results.getString("id"));
				item.setMerk(results.getString("id"));
				item.setSellPrice(results.getInt("id"));
				items.add(item);
			}
		} catch (Exception e) {
			throw e;
		}
		return items;
	}

	public void update(int id, UpdateItemDTO item) throws Exception {
		try {
			PreparedStatement stmt = this.conn.prepareStatement("UPDATE `inventaris`.`items` SET `code` = ?, `description` = ?, `size` = ?, `article` = ?, `sell_price` = ?, `merk` = ? WHERE `id` = ?");
			stmt.setString(1, item.getCode());
			stmt.setString(2, item.getDescription());
			stmt.setString(3, item.getSize());
			stmt.setString(4, item.getArticle());
			stmt.setInt(5, item.getSellPrice());
			stmt.setString(6, item.getMerk());
			stmt.setInt(7, id);
		} catch (Exception e) {
			throw e;
		}	
	}

	public void destroy() {

	}
}
