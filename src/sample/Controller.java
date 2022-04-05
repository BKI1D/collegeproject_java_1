package sample;
//import
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
//base
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.lang.*;
import javafx.scene.input.InputMethodEvent;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//Controls init
public class Controller {

    //Variables
    protected String Aut_Login;
    protected String Aut_Pass;

    protected String Input_Reg_Login;
    protected String Input_Reg_Pass;
    protected String Inpute_Reg_Email;

    //Id desc
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane Pane1;

    @FXML
    private Button S1_RegButton1;

    @FXML
    private Button S1_LoginButton1;

    @FXML
    protected TextField S1_InputField1;

    @FXML
    private TextField S1_InputField2;

    @FXML
    private Pane Pane2;

    @FXML
    private TextField RegLogInput;

    @FXML
    private TextField RegPassInput;

    @FXML
    private TextField RegConfirmPassInput;

    @FXML
    private TextField RegInputEmail;

    @FXML
    private Button Reg_ConfirmReg1;

    @FXML
    private Button Reg_ConfirmAdmin1;

    @FXML
    private TextField RegInputAdmin;

    @FXML
    private Button BackButton1;

    //Default Init variables
    void DefaultVarInit()
    {
       Aut_Pass="";
       Aut_Login="";
       Input_Reg_Login="";
       Input_Reg_Pass="";
       Inpute_Reg_Email="";
    }
    //Visible Panel
    //SetAllPaneltoFalse
    void DefaultVisible()
    {
        Pane1.setVisible(false);
        Pane2.setVisible(false);
    }
    //init
    @FXML
    void initialize() {
        DefaultVarInit();
    }
    //Functional Methods

    @FXML
    void Log_LogInput(InputMethodEvent event)
    {

    }
    //Login button
    @FXML
    void LoginStartAction(ActionEvent event)
    {
        Aut_Login = S1_InputField1.getText();
        Aut_Pass= S1_InputField2.getText();
        DatabaseHandle dbHandleU=new DatabaseHandle();
        dbHandleU.UpdateROMtable(Aut_Login);
        S1_Methods a=new S1_Methods();
        try {
            if (Aut_Login!="" && Aut_Pass !="" && !Aut_Login.isEmpty() && !Aut_Pass.isEmpty())
            {
                a.Aut_Check(Aut_Login,Aut_Pass);
            }
            else
            {
                //create alert
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Ошибка");
                alert.setContentText("Пустые значения");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Password button
    @FXML
    void RegisterStartAction(ActionEvent event)
    {
        DefaultVisible();
        Pane2.setVisible(true);
    }
    //ConfirmReg
    @FXML
    void ConfirmRegister1(ActionEvent event)
    {
        Reg_CreateUser();
    }
    //proc for action ConfrimReg
    void Reg_CreateUser()
    {
        //local variables
        String ConfPass = RegConfirmPassInput.getText();
        //Get values
        Input_Reg_Login=RegLogInput.getText();
        Input_Reg_Pass=RegPassInput.getText();
        Inpute_Reg_Email=RegInputEmail.getText();
        //check for emptyness
        if (Inpute_Reg_Email !="" && Input_Reg_Pass !="" && Input_Reg_Login !="" && ConfPass !="")
        {
            //check pass
            if (ConfPass.equals(Input_Reg_Pass))
            {
                S1_Methods rg=new S1_Methods();
                rg.RegistrationProc(Input_Reg_Login,Input_Reg_Pass,Inpute_Reg_Email,0);
                RegLogInput.clear();
                RegPassInput.clear();
                RegConfirmPassInput.clear();
                RegInputEmail.clear();
                RegInputAdmin.clear();
            }
            else
            {
                //create alert
                Alert alerta = new Alert(AlertType.INFORMATION);
                alerta.setTitle("Ошибка ввода");
                alerta.setContentText("Пароли не совпадают");
                alerta.showAndWait();
            }
        }
        else
        {
             //create alert
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ошибка");
            alert.setContentText("Пустые значения");
            alert.showAndWait();
        }
    }
    //Administrator registration
    @FXML
    void ConfirmRegisterAdmin1(ActionEvent event) throws SQLException {
        String AdminPassforCheck=RegInputAdmin.getText();

        String A_Log=RegLogInput.getText();
        String A_Pass=RegPassInput.getText();
        String A_PassConf=RegConfirmPassInput.getText();
        String A_Mail=RegInputEmail.getText();

        if (!AdminPassforCheck.equals("") && !A_Log.equals("") && !A_Pass.equals("") && !A_PassConf.equals("") && !A_Mail.equals(""))
        {
            if (A_Pass.equals(A_PassConf))
            {
                DatabaseHandle dbRegHndl=new DatabaseHandle();
                ResultSet GetAdmSet=dbRegHndl.SelectAdminPass();
                String PsSStr="";
                int columnss = GetAdmSet.getMetaData().getColumnCount();
                while (GetAdmSet.next()) {
                    for (int j = 1; j <= columnss; j++) {
                        PsSStr = GetAdmSet.getString(j);
                    }
                }
                if (AdminPassforCheck.equals(PsSStr))
                {
                    S1_Methods toarg=new S1_Methods();
                    toarg.RegistrationProc(A_Log,A_Pass,A_PassConf,1);
                    RegLogInput.clear();
                    RegPassInput.clear();
                    RegConfirmPassInput.clear();
                    RegInputEmail.clear();
                    RegInputAdmin.clear();
                }
                else
                {
                    Alert alertya = new Alert(AlertType.INFORMATION);
                    alertya.setTitle("Ошибка");
                    alertya.setContentText("Пароль администратора введен не верно");
                    alertya.showAndWait();
                }
                S1_Methods rg=new S1_Methods();

            }
            else
            {
                Alert alerty = new Alert(AlertType.INFORMATION);
                alerty.setTitle("Ошибка");
                alerty.setContentText("Пароли не совпадают");
                alerty.showAndWait();
            }
        }
        else
        {
            Alert alerty = new Alert(AlertType.INFORMATION);
            alerty.setTitle("Ошибка");
            alerty.setContentText("Пустые значения");
            alerty.showAndWait();
        }
    }
    //Go back from reg page
    @FXML
    void RegGoBack1(ActionEvent event) {
        DefaultVisible();
        Pane1.setVisible(true);
    }
    //Additional Methods
    //RegButton
    @FXML
    void RegMouseEnter(MouseEvent event)
    {
        S1_RegButton1.setStyle("-fx-background-color:  #facf5a;");
    }
    @FXML
    void RegMouseExited(MouseEvent event)
    {
        S1_RegButton1.setStyle("-fx-background-color:  #ffffff");
    }
    //
    //MouseButton
    @FXML
    void LgnMouseEnter(MouseEvent event)
    {
        S1_LoginButton1.setStyle("-fx-background-color:  #facf5a;");
    }
    @FXML
    void LgnMouseExit(MouseEvent event)
    {
        S1_LoginButton1.setStyle("-fx-background-color:  #ffffff");
    }
    //Unused Methods
    @FXML
    void LgnBtnDragOver(MouseDragEvent event)
    {

    }
    @FXML
    void LgnBtnDragReleased(MouseDragEvent event) {

    }
    @FXML
    void RegBtnDragOver(MouseDragEvent event)
    {

    }
    @FXML
    void RegBtnMouseRelease(MouseDragEvent event)
    {

    }
    @FXML
    void RegLogInputChanged(InputMethodEvent event) {

    }
    @FXML
    void InputMailChanged(InputMethodEvent event) {

    }

    @FXML
    void InputPassChanged(InputMethodEvent event) {

    }

    @FXML
    void InputPassConfirmChanged(InputMethodEvent event) {

    }
    @FXML
    void LogInputAction(ActionEvent event)
    {

    }
    @FXML
    void PassInputAction(ActionEvent event)
    {

    }
}