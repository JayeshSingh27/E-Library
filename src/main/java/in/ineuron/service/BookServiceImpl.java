package in.ineuron.service;


import in.ineuron.dao.IBookDao;
import in.ineuron.daofactory.BookDaoFactory;
import in.ineuron.dto.BookDto;

public class BookServiceImpl implements IBookService
{
	private IBookDao bookdao;
	@Override
	public String addbook(BookDto book) {
		// TODO Auto-generated method stub
		bookdao = BookDaoFactory.getbookdao();
		return bookdao.addbook(book);
	}

	@Override
	public String deletebook(Integer bookId) {
		// TODO Auto-generated method stub
		bookdao = BookDaoFactory.getbookdao();
		return bookdao.deletebook(bookId);
	}

	@Override
	public BookDto searchbookbyauthor(String bookAuthor) {
		// TODO Auto-generated method stub
		bookdao = BookDaoFactory.getbookdao();
		return bookdao.searchbookbyauthor(bookAuthor);
	}

	@Override
	public BookDto searchbookbyname(String bookName) {
		// TODO Auto-generated method stub
		return bookdao.searchbookbyname(bookName);
	}

	@Override
	public BookDto searchbookbygenre(String bookGenre) {
		// TODO Auto-generated method stub
		bookdao = BookDaoFactory.getbookdao();
		return bookdao.searchbookbygenre(bookGenre);
	}

	@Override
	public String updatebook(BookDto book) {
		// TODO Auto-generated method stub
		bookdao = BookDaoFactory.getbookdao();
		return bookdao.updatebook(book);
	}
	
}
