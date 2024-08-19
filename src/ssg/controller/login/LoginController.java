package ssg.controller.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ssg.controller.customerservice.CustomerServiceController;
import ssg.controller.outbound.OutboundController;
import ssg.library.script.LoginScript;
import ssg.service.login.LoginService;

public class LoginController {

  private final LoginScript loginScript = LoginScript.getLoginScriptInstance();
  private LoginService loginService = new LoginService();

  CustomerServiceController customerServiceController = new CustomerServiceController();
  OutboundController outboundController = new OutboundController();

  /**
   * 프로그램 실행시 처음 시작하는 메뉴
   */
  public void startMenu() {
    boolean isOn = true;
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      while (isOn) {
        try {
        loginScript.printStartMenu();
        int select = Integer.parseInt(br.readLine());
          switch (select) {
            case 1 -> {
              loginService.createMember(br);
            }
            case 2 -> {
              loginService.loginStart(br);
            }
            case 3 -> {
              System.out.println("운송장 조회");
            }
            case 4 -> {
              customerServiceController.startMenu();
            }
            case 5 -> {
              loginService.findID(br);
            }
            case 6 -> {
              loginService.findPassWord(br);
            }
            case 7 -> {
              System.out.println("종료");
              isOn = false;
            }
            case 999 -> loginService.createAdmin(br);
            default -> throw new NumberFormatException();
          }
        }catch (NumberFormatException e) {
          loginScript.printFaultInput();
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
      }
  }
}

// /** 로그인 선택시 뜨는 메뉴 */
  /*public void loginMenu() {

    try {
      //loginScript.printLoginAllMenu();
      int select = Integer.parseInt(br.readLine());

      switch (select) {
        case 1 -> loginService.loginStart();
        case 2 -> loginService.findID();
        case 3 -> loginService.findPassWord();
        case 4 -> loginService.createMember();
        case 5 -> startMenu();
        case 99 -> loginService.createAdmin();
        default -> throw new NumberFormatException();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (NumberFormatException e) {
      loginScript.printFaultInput();
    }
  }*/


