package movieTicketing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try (ServerSocket serverSocket = new ServerSocket(7777);
				Socket socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
			System.out.println("클라이언트 접속 성공");
			String msg = null;

			msg = ("1.예매 2.취소 3.조회 4.금액조회");
			System.out.println("1.예매 2.취소 3.조회 4.금액조회");
			bw.write("기능을 선택해주세요");
			bw.newLine();
			bw.flush();
			bw.write(msg);
			bw.newLine();
			bw.flush();

			msg = br.readLine();
			System.out.println("읽은 값 : " + msg);
			int answer = Integer.valueOf(msg);

			switch (answer) {
			case 1: // 예매 선택
				String sql = "select name from employee_db.cinema";

				try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
					try (ResultSet rs = pst.executeQuery()) {
						List<String> cinemaList = new ArrayList<String>();
						String cinema = "";
						while (rs.next()) {
							cinemaList.add(rs.getString("name"));
						}
						for (int i = 0; i < cinemaList.size(); i++) {
							cinema += (i + 1) + ". " + cinemaList.get(i) + " ";
						}
						System.out.println(cinema);
						bw.write("영화관을 선택해주세요");
						bw.newLine();
						bw.flush();
						bw.write(cinema);
						bw.newLine();
						bw.flush();

						msg = br.readLine();
						System.out.println("읽은 값 : " + msg);
						answer = Integer.valueOf(msg);
					}

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				switch (answer) {
				case 1: // 용산아이파크몰 선택
					sql = "select m.title from employee_db.movie m join  theater_time tt on m.id = tt.movie_id join cinema c on c.id = tt.cinema_id where c.id = 1 group by m.title";

					try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
						try (ResultSet rs = pst.executeQuery()) {
							List<String> movieList = new ArrayList<String>();
							String movie = "";
							while (rs.next()) {
								movieList.add(rs.getString("title"));
							}
							for (int i = 0; i < movieList.size(); i++) {
								movie += (i + 1) + ". " + movieList.get(i) + " ";
							}
							System.out.println(movie);
							bw.write("예매하실 영화를 선택해주세요");
							bw.newLine();
							bw.flush();
							bw.write(movie);
							bw.newLine();
							bw.flush();

							msg = br.readLine();
							System.out.println("읽은 값 : " + msg);
							answer = Integer.valueOf(msg);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					switch (answer) {
					case 1:
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id where c.id = 1 group by t.theater";

						try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
							try (ResultSet rs = pst.executeQuery()) {
								List<String> movieList = new ArrayList<String>();
								String theater = "";
								while (rs.next()) {
									movieList.add(rs.getString("theater"));
								}
								for (int i = 0; i < movieList.size(); i++) {
									theater += (i + 1) + ". " + movieList.get(i) + " ";
								}
								System.out.println(theater);
								bw.write("예매하실 상영관을 선택해주세요");
								bw.newLine();
								bw.flush();
								bw.write(theater);
								bw.newLine();
								bw.flush();

								msg = br.readLine();
								System.out.println("읽은 값 : " + msg);
								answer = Integer.valueOf(msg);
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					}

					break;
				case 2: // 압구정 선택
					sql = "select m.title from employee_db.movie m join  theater_time tt on m.id = tt.movie_id join cinema c on c.id = tt.cinema_id where c.id = 2 group by m.title;";

					try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
						try (ResultSet rs = pst.executeQuery()) {
							List<String> movieList = new ArrayList<String>();
							String movie = "";
							while (rs.next()) {
								movieList.add(rs.getString("title"));
							}
							for (int i = 0; i < movieList.size(); i++) {
								movie += (i + 1) + ". " + movieList.get(i) + " ";
							}
							System.out.println(movie);
							bw.write("영화관을 선택해주세요");
							bw.newLine();
							bw.flush();
							bw.write(movie);
							bw.newLine();
							bw.flush();

							msg = br.readLine();
							System.out.println("읽은 값 : " + msg);
							answer = Integer.valueOf(msg);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 3: // 송파 선택
					sql = "select m.title from employee_db.movie m join  theater_time tt on m.id = tt.movie_id join cinema c on c.id = tt.cinema_id where c.id = 3 group by m.title;";

					try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
						try (ResultSet rs = pst.executeQuery()) {
							List<String> movieList = new ArrayList<String>();
							String movie = "";
							while (rs.next()) {
								movieList.add(rs.getString("title"));
							}
							for (int i = 0; i < movieList.size(); i++) {
								movie += (i + 1) + ". " + movieList.get(i) + " ";
							}
							System.out.println(movie);
							bw.write("영화관을 선택해주세요");
							bw.newLine();
							bw.flush();
							bw.write(movie);
							bw.newLine();
							bw.flush();

							msg = br.readLine();
							System.out.println("읽은 값 : " + msg);
							answer = Integer.valueOf(msg);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 4: // 영등포 선택
					sql = "select m.title from employee_db.movie m join  theater_time tt on m.id = tt.movie_id join cinema c on c.id = tt.cinema_id where c.id = 4 group by m.title;";

					try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
						try (ResultSet rs = pst.executeQuery()) {
							List<String> movieList = new ArrayList<String>();
							String movie = "";
							while (rs.next()) {
								movieList.add(rs.getString("title"));
							}
							for (int i = 0; i < movieList.size(); i++) {
								movie += (i + 1) + ". " + movieList.get(i) + " ";
							}
							System.out.println(movie);
							bw.write("영화관을 선택해주세요");
							bw.newLine();
							bw.flush();
							bw.write(movie);
							bw.newLine();
							bw.flush();

							msg = br.readLine();
							System.out.println("읽은 값 : " + msg);
							answer = Integer.valueOf(msg);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
