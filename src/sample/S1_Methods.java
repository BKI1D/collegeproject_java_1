package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class S1_Methods extends Main
{
    //Variables
    protected String DbUsPass;
//Autorithation
    void Aut_Check(String LoginToCheck, String PassToCheck) throws Exception {
        DatabaseHandle dbHandler;
        dbHandler = new DatabaseHandle();
        User user = new User();
        user.setLogin(LoginToCheck);
        user.setPassword(PassToCheck);
        ResultSet rez=dbHandler.getUser(user);

        int counter = 0;

        try
        {
            while (rez.next())
            {
                counter++;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();;
        }

        if (counter>=1)
        {
            //create alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Результат авторизации");
            alert.setContentText("Добро пожаловать!");
            alert.showAndWait();
//Open new Page
            S1_to_S2(LoginToCheck);
        }

    }
    void S1_to_S2(String toGUI_CurrentUser) throws Exception
    {
        Stage S2 =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ProgramMenu.fxml"));
        S2.setTitle("SPM");
        S2.setScene(new Scene(root, 1080, 720));
        S2.show();
        S2.setResizable(false);

    }
    //Register New User
    void RegistrationProc(String R_Login, String R_Pass, String R_Email, int r_Code)
    {
        User SendUser = new User();
        SendUser.setLogin(R_Login);
        SendUser.setPassword(R_Pass);
        SendUser.setEmail(R_Email);
        SendUser.setAccessCode(r_Code);
        //Send User to db class
        DatabaseHandle dbRegHd=new DatabaseHandle();
        dbRegHd.signUpUser(SendUser);
        //alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Результат регистрации");
        alert.setContentText("Вы успешно зарегестрировались");
        alert.showAndWait();
    }
}
