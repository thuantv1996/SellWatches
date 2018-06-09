package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.CategoryDAO;
import j2ee.spring.sellwatches.models.Category;
import j2ee.spring.sellwatches.services.MSSQLService;

@Component
public class CategoryServiceImplement implements MSSQLService<Category> {

	@Autowired
	private CategoryDAO categoryDAO;
	
	public List<Category> select() {
		// TODO Auto-generated method stub
		return categoryDAO.select();
	}

	public boolean insert(Category t) {
		// TODO Auto-generated method stub
		return categoryDAO.insert(t);
	}

	public boolean update(Category t) {
		// TODO Auto-generated method stub
		return categoryDAO.update(t);
	}

	public boolean delete(Object[] idPara) {
		// TODO Auto-generated method stub
		return categoryDAO.delete(idPara);
	}

	public Category findById(Object[] idPara) {
		// TODO Auto-generated method stub
		return categoryDAO.findById(idPara);
	}

}
