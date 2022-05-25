package frm;

import frm.frmDangNhap;
import frm._FrameMain;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author PLanh
 */
public class Main {
    public static  frm._FrameMain frmTC=new _FrameMain();
    public static frm.clsConnectDB connection = new  frm.clsConnectDB ();

    public static void main(String[] args) {
       frm.frmDangNhap frmDN= new   frm.frmDangNhap();
  
       frmDN.show();
    }
   
      
}
