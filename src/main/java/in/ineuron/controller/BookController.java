package in.ineuron.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.BookDto;
import in.ineuron.service.IBookService;
import in.ineuron.servicefactory.BookServiceFactory;


@WebServlet("/BookController/*")
public class BookController extends HttpServlet 
{
	ResultSet rs = null;
	BookDto book=null;
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	private void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBookService bookservice = BookServiceFactory.getbookservice();
		if(request.getRequestURI().endsWith("searchbyauthor"))
		{
			book = new BookDto();
			String authorname = request.getParameter("book_author");
			book = bookservice.searchbookbyauthor(authorname);
			request.setAttribute("book", book);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../displaybookbyauthor.jsp");
			rd.forward(request, response);			
		}
		if(request.getRequestURI().endsWith("searchbyname")) {
			book = new BookDto();
			String bookname = request.getParameter("book_name");
			book = bookservice.searchbookbyname(bookname);
			request.setAttribute("book", book);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../displaybookbyauthor.jsp");
			rd.forward(request, response);		
			
		}
		if(request.getRequestURI().endsWith("searchbygenre")) {
			book = new BookDto();
			String genrename = request.getParameter("genre_name");
			book = bookservice.searchbookbygenre(genrename);
			request.setAttribute("book", book);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../displaybookbyauthor.jsp");
			rd.forward(request, response);		
		}
		if(request.getRequestURI().endsWith("addbook")) {
			book = new BookDto();
			book.setBookId(Integer.parseInt(request.getParameter("book_id")));
			book.setBookName(request.getParameter("book_name"));
			book.setBookAuthor(request.getParameter("book_author"));
			book.setBookGenre(request.getParameter("book_genre"));
			book.setBookQuantity(Integer.parseInt(request.getParameter("book_quantity")));
			String status = bookservice.addbook(book);
			RequestDispatcher rd = null;
			request.setAttribute("status", "failed");
			if(status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../addbookstatus.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getRequestURI().endsWith("updatebook")) {
			book = new BookDto();
			book.setBookId(Integer.parseInt(request.getParameter("book_id")));
			book.setBookName(request.getParameter("book_name"));
			book.setBookAuthor(request.getParameter("book_author"));
			book.setBookGenre(request.getParameter("book_genre"));
			book.setBookQuantity(Integer.parseInt(request.getParameter("book_quantity")));
			String status = bookservice.updatebook(book);
			RequestDispatcher rd = null;
			request.setAttribute("status", "failed");
			if(status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../updatebookstatus.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getRequestURI().endsWith("deletebook")) {
			Integer bid = Integer.parseInt(request.getParameter("book_id"));
			String status = bookservice.deletebook(bid);
			RequestDispatcher rd = null;
			request.setAttribute("status", "failed");
			if(status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../deletebookstatus.jsp");
				rd.forward(request, response);
			}
		}
	}

}
