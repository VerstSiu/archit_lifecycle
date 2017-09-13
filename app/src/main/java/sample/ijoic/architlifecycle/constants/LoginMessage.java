package sample.ijoic.architlifecycle.constants;

/**
 * Login message.
 *
 * @author verstSiu verstsiu@126.com
 * @version 1.0
 */
public interface LoginMessage {
  int MSG_USERNAME_EMPTY = 0x01;
  int MSG_PASSWORD_EMPTY = 0x02;
  int MSG_USERNAME_ERROR = 0x03;
  int MSG_PASSWORD_ERROR = 0x04;
  int MSG_LOGIN_SUCCESS = 0x05;
}
