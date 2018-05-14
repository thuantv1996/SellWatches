package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.CategoryDAO;
import j2ee.spring.sellwatches.dao.DetailInvoiceDAO;
import j2ee.spring.sellwatches.models.DetailInvoice;
import j2ee.spring.sellwatches.services.MSSQLService;

@Component
public class DetailInvoiceServiceImplement implements MSSQLService<DetailInvoice>{

	@Autowired
	private DetailInvoiceDAO detailInvoiceDAO;
	
	public List<DetailInvoice> select() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(DetailInvoice t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(DetailInvoice t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Object[] idPara) {
		// TODO Auto-generated method stub
		return false;
	}

	public DetailInvoice findById(Object[] idPara) {
		return detailInvoiceDAO.findById(idPara);
	}

}
