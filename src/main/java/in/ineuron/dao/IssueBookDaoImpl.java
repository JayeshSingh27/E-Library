package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.ineuron.dto.IssueDto;
import in.ineuron.util.JdbcUtil;

public class IssueBookDaoImpl implements IIssueBookDao 
{
	Connection connection = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3,pstmt4 = null;
	ResultSet rs,rs1 = null;
	IssueDto issue = null;
	@Override
	public String issuebook(IssueDto issue) {
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlSelectQuery = "select bookQuantity from bookdb where bookId=?";
			String sqlInsertQuery = "insert into issuedb (`bookId`,`bookIssueDate`,`bookIssueDueDate`,`studentId`) values (?,?,?,?)";
			String sqlUpdateQuery = "update bookdb set bookQuantity=? where bookId=?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
				pstmt.setInt(1, issue.getBookId());
				if(pstmt != null) {
					rs = pstmt.executeQuery();
					if(rs != null)
					{
						if(rs.next())
						{
							int bookQuantityValue = rs.getInt(1);
							if(bookQuantityValue == 0) {
								return "failed1";
							}
							else 
							{
								
										pstmt2 = connection.prepareStatement(sqlInsertQuery);
										pstmt2.setInt(1, issue.getBookId());
										pstmt2.setString(2, issue.getBookIssueDate());
										pstmt2.setString(3,issue.getBookIssueDueDate());
										pstmt2.setInt(4, issue.getStudentId());
										if(pstmt2 != null) 
										{
											int rowsAffected = pstmt2.executeUpdate();
											if(rowsAffected == 1) 
											{
												pstmt3 = connection.prepareStatement(sqlUpdateQuery);
												pstmt3.setInt(1, bookQuantityValue-1);
												pstmt3.setInt(2, issue.getBookId());
												int rowsAffectedd  = pstmt3.executeUpdate();
												if(rowsAffectedd == 1) 
												{
													return "success";
												}
											}
										}
									}
								}

							}
						}					
					}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
	}

	@Override
	public IssueDto returnbook(Integer bookId) {
		// TODO Auto-generated method stub
		try {			
			connection = JdbcUtil.getJdbcConnection();
			String sqlDeleteQuery = "delete from issuedb where studentId=?";
			String sqlSelectQuery = "select bookQuantity from bookdb where bookId=?";
			String sqlUpdateQuery = "update bookdb set bookQuantity=? where bookId=?";
			String sqlSelectQueryFinal ="select bookId,bookIssueDate,bookIssueDueDate,bookQuantity from issuedb where bookId=?"; 
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
				pstmt.setInt(1,bookId);
				if(pstmt != null) {
					int rowsAffected = pstmt.executeUpdate();
					if(rowsAffected == 1) 
					{
						pstmt2 = connection.prepareStatement(sqlSelectQuery);
						pstmt2.setInt(1, bookId);
						if(pstmt2 != null) {
							rs = pstmt2.executeQuery();
							if(rs!=null) {
								if(rs.next()) 
								{
									int quantity = rs.getInt(1);
									pstmt3 = connection.prepareStatement(sqlUpdateQuery);
									pstmt3.setInt(1, quantity+1);
									pstmt3.setInt(2, bookId);
									if(pstmt3 != null) {
										int rowsAffectedd = pstmt3.executeUpdate();
										if(rowsAffectedd == 1) {
											pstmt4 = connection.prepareStatement(sqlSelectQueryFinal);
											pstmt4.setInt(1, bookId);
											if(pstmt4 != null) {
												rs1 = pstmt4.executeQuery();
												if(rs1 != null) {
													if(rs1.next()) {
														issue = new IssueDto();
														issue.setBookId(rs1.getInt(1));
														issue.setBookIssueDate(rs.getString(2));
														issue.setBookIssueDueDate(rs.getString(3));
														issue.setStudentId(rs.getInt(4));
														return issue;
													}
												}
											}
										}					
									}
								}
							}
						}
					}				
				}
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String checkdue(Integer studentId) {
		// TODO Auto-generated method stub
		try {
			String ans=null;
			connection = JdbcUtil.getJdbcConnection();
			String sqlSelectQuery ="select bookIssueDueDate from issuedb where studentId=?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
				pstmt.setInt(1, studentId);
				if(pstmt != null) {
					rs = pstmt.executeQuery();
					if(rs != null) 
					{	
						if(rs.next())
							ans = rs.getString(1);
							return  ans;		
					}
								
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return null;
	}

}
