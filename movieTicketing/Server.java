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
			String msg = "";
			Business busi = new Business();
			Premium pre = new Premium();

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
					case 1: // 007
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where m.id = 1 group by t.theater;";

						try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
							try (ResultSet rs = pst.executeQuery()) {
								List<String> theaterList = new ArrayList<String>();
								String theater = "";
								while (rs.next()) {
									theaterList.add(rs.getString("theater"));
								}
								for (int i = 0; i < theaterList.size(); i++) {
									theater += (i + 1) + ". " + theaterList.get(i) + " ";
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
						switch (answer) {
						case 1: // business
							sql = "select tt.time from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where t.id = 1 && c.id = 1 && m.id = 1;";

							try (Connection conn = MyConn.getConn();
									PreparedStatement pst = conn.prepareStatement(sql)) {
								try (ResultSet rs = pst.executeQuery()) {
									List<String> timeList = new ArrayList<String>();
									String time = "";
									while (rs.next()) {
										timeList.add(rs.getString("time"));
									}
									for (int i = 0; i < timeList.size(); i++) {
										time += (i + 1) + ". " + timeList.get(i) + " ";
									}
									System.out.println(time);
									bw.write("예매하실 시간을 선택해주세요");
									bw.newLine();
									bw.flush();
									bw.write(time);
									bw.newLine();
									bw.flush();
									
									msg = br.readLine();
									System.out.println("읽은 값 : " + msg);
									answer = Integer.valueOf(msg);
									
									msg = busi.sysoutBusi();
									bw.write(msg);
									bw.newLine();
									bw.flush();
									
									bw.write("예매하실 좌석의 행을 선택해주세요");
									bw.newLine();
									bw.flush();
									String answer1 = br.readLine();
									System.out.println(answer1);
									bw.write("예매하실 좌석의 열을 선택해주세요");
									bw.newLine();
									bw.flush();
									int answer2 = Integer.valueOf(br.readLine());
									System.out.println(answer2);
									
									busi.setSeat(answer1, answer2);
									
									msg = busi.sysoutBusi();
									bw.write(msg);
									bw.newLine();
									bw.flush();
									
									msg = ("좌석번호 "+answer1+"-"+answer2);
									bw.write(msg);
									bw.newLine();
									bw.flush();
									
								}
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							sql = "select pr.age, pr.price from theater_price pr join theater t on pr.theater_id = t.id where t.id = 1 group by pr.age;";

							try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
								try (ResultSet rs = pst.executeQuery()) {
									List<String> ageList = new ArrayList<String>();
									List<String> priceList = new ArrayList<String>();
									String age = "";
									while (rs.next()) {
										ageList.add(rs.getString("age"));
										priceList.add(rs.getString("price"));
									}
									for (int i = 0; i < ageList.size(); i++) {
										age += (i + 1) + ". " + ageList.get(i) +" ";
									}
									System.out.println(age);
									bw.write("예매하실 티켓을 선택해주세요");
									bw.newLine();
									bw.flush();
									bw.write(age);
									bw.newLine();
									bw.flush();

									msg = br.readLine();
									System.out.println("읽은 값 : " + msg);
									answer = Integer.valueOf(msg);
									
									switch (answer) {
									case 1: //일반
										bw.write(priceList.get(1)+"원 입니다");
										bw.newLine();
										bw.flush();
										break;
									case 2: //청소년
										bw.write(priceList.get(2)+"원 입니다");
										bw.newLine();
										bw.flush();
										break;
									case 3: //경로
										bw.write(priceList.get(3)+"원 입니다");
										bw.newLine();
										bw.flush();
										break;
									case 4: //우대
										bw.write(priceList.get(4)+"원 입니다");
										bw.newLine();
										bw.flush();
										break;
									
									}
								}
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							
							break;
						case 2: // premium
							sql = "select tt.time from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where t.id = 2 && c.id = 1 && m.id = 1;";

							try (Connection conn = MyConn.getConn();
									PreparedStatement pst = conn.prepareStatement(sql)) {
								try (ResultSet rs = pst.executeQuery()) {
									List<String> timeList = new ArrayList<String>();
									String time = "";
									while (rs.next()) {
										timeList.add(rs.getString("time"));
									}
									for (int i = 0; i < timeList.size(); i++) {
										time += (i + 1) + ". " + timeList.get(i) + " ";
									}
									System.out.println(time);
									bw.write("예매하실 시간을 선택해주세요");
									bw.newLine();
									bw.flush();
									bw.write(time);
									bw.newLine();
									bw.flush();

									msg = br.readLine();
									System.out.println("읽은 값 : " + msg);
									answer = Integer.valueOf(msg);
									
									msg = pre.sysoutPre();
									bw.write(msg);
									bw.newLine();
									bw.flush();
									
									bw.write("예매하실 좌석의 열을 선택해주세요");
									bw.newLine();
									bw.flush();
									int answer2 = Integer.valueOf(br.readLine());
									System.out.println(answer2);
									
									pre.setSeat(answer2);
									
									msg = busi.sysoutBusi();
									bw.write(msg);
									bw.newLine();
									bw.flush();
									
									msg = ("좌석번호 "+"A-"+answer2);
									bw.write(msg);
									bw.newLine();
									bw.flush();
									
								}
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							sql = "select pr.age from theater_price pr join theater t on pr.theater_id = t.id where t.id = 1 group by pr.age;";

							try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
								try (ResultSet rs = pst.executeQuery()) {
									List<String> ageList = new ArrayList<String>();
									List<String> priceList = new ArrayList<String>();
									String age = "";
									while (rs.next()) {
										ageList.add(rs.getString("age"));
										priceList.add(rs.getString("price"));
									}
									for (int i = 0; i < ageList.size(); i++) {
										age += (i + 1) + ". " + ageList.get(i) +" ";
									}
									System.out.println(age);
									bw.write("예매하실 티켓을 선택해주세요");
									bw.newLine();
									bw.flush();
									bw.write(age);
									bw.newLine();
									bw.flush();

									msg = br.readLine();
									System.out.println("읽은 값 : " + msg);
									answer = Integer.valueOf(msg);
									
									switch (answer) {
									case 1: //일반
										bw.write(priceList.get(1)+"원 입니다");
										bw.newLine();
										bw.flush();
										break;
									case 2: //청소년
										bw.write(priceList.get(2)+"원 입니다");
										bw.newLine();
										bw.flush();
										break;
									case 3: //경로
										bw.write(priceList.get(3)+"원 입니다");
										bw.newLine();
										bw.flush();
										break;
									case 4: //우대
										bw.write(priceList.get(4)+"원 입니다");
										bw.newLine();
										bw.flush();
										break;
									
									}
									
								}
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							break;
						case 3: // goldclass
							sql = "select tt.time from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where t.id = 3 && c.id = 1 && m.id = 1;";

							try (Connection conn = MyConn.getConn();
									PreparedStatement pst = conn.prepareStatement(sql)) {
								try (ResultSet rs = pst.executeQuery()) {
									List<String> timeList = new ArrayList<String>();
									String time = "";
									while (rs.next()) {
										timeList.add(rs.getString("time"));
									}
									for (int i = 0; i < timeList.size(); i++) {
										time += (i + 1) + ". " + timeList.get(i) + " ";
									}
									System.out.println(time);
									bw.write("예매하실 시간을 선택해주세요");
									bw.newLine();
									bw.flush();
									bw.write(time);
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
						case 4: // 4dx
							sql = "select tt.time from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where t.id = 4 && c.id = 1 && m.id = 1;";

							try (Connection conn = MyConn.getConn();
									PreparedStatement pst = conn.prepareStatement(sql)) {
								try (ResultSet rs = pst.executeQuery()) {
									List<String> timeList = new ArrayList<String>();
									String time = "";
									while (rs.next()) {
										timeList.add(rs.getString("time"));
									}
									for (int i = 0; i < timeList.size(); i++) {
										time += (i + 1) + ". " + timeList.get(i) + " ";
									}
									System.out.println(time);
									bw.write("예매하실 시간을 선택해주세요");
									bw.newLine();
									bw.flush();
									bw.write(time);
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
						case 5: // imax
							sql = "select tt.time from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where t.id = 5 && c.id = 1 && m.id = 1;";

							try (Connection conn = MyConn.getConn();
									PreparedStatement pst = conn.prepareStatement(sql)) {
								try (ResultSet rs = pst.executeQuery()) {
									List<String> timeList = new ArrayList<String>();
									String time = "";
									while (rs.next()) {
										timeList.add(rs.getString("time"));
									}
									for (int i = 0; i < timeList.size(); i++) {
										time += (i + 1) + ". " + timeList.get(i) + " ";
									}
									System.out.println(time);
									bw.write("예매하실 시간을 선택해주세요");
									bw.newLine();
									bw.flush();
									bw.write(time);
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
					case 2: // 수색자
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where m.id = 2 group by t.theater;";

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
					case 3: // 보이스
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where m.id = 3 group by t.theater;";

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
					case 4: // 기적
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where m.id = 4 group by t.theater;";

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
					case 5: // 모가디슈
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where m.id = 5 group by t.theater;";

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
					case 6: // 위플래쉬
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where m.id = 6 group by t.theater;";

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
					case 7: // 짱구
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where m.id = 7 group by t.theater;";

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
					case 8: // 샹치
						sql = "select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id join movie m on m.id = tt.movie_id where m.id = 8 group by t.theater;";

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
