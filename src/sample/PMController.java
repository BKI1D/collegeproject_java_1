package sample;

//from basement
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

//adds
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class PMController {
    //variables
    String Send_SearchGroup;

    String Send_SearchGroupNumber;
    String Send_SearchNamesString;

    String AddingM_D_Date1; //Base Dedline date
    String AddingM_D_Date2; //Concept dedline date
    String AddingM_D_Date3; //Base func date
    String AddingM_D_Date4; //Add func date
    String AddingM_D_Date5; //Doc Date

    String AddingGroupName;

    int AddingCouner;
    int GrpCounter;

    Boolean Date1Check;
    Boolean Date2Check;
    Boolean Date3Check;
    Boolean Date4Check;
    Boolean Date5Check;
    //fxml
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Manage_AddProjectsButton;

    @FXML
    private Pane Manage_Scene;

    @FXML
    private Button CloseProject1;

    @FXML
    private Label Labl_BaseDedline;

    @FXML
    private Label Labl_NameInf;

    @FXML
    private Label Labl_SecNameInf;

    @FXML
    private Label Labl_ConceptDedline;

    @FXML
    private Label Labl_ConceptDedlineRec;

    @FXML
    private Label Labl_ConceptDedlineMark;

    @FXML
    private Label Labl_FuncBaseDedline;

    @FXML
    private Label Labl_FuncBaseDedlineRec;

    @FXML
    private Label Labl_FuncBaseDedlineMark;

    @FXML
    private Label Labl_FuncAddDedline;

    @FXML
    private Label Labl_FuncAddDedlineRec;

    @FXML
    private Label Labl_FuncAddDedlineMark;

    @FXML
    private Label Labl_DocDedline;

    @FXML
    private Label Labl_DocDedlineRec;

    @FXML
    private Label Labl_DocMark;

    @FXML
    private Label Labl_TotalMark;

    @FXML
    private Label Labl_ThemeCompilInfo;

    @FXML
    private Label Labl_PassedCount;

    @FXML
    private Label GUIUserLable;

    @FXML
    private Pane PreCheck_Scene;

    @FXML
    private Pane Check_Scene;

    @FXML
    private ListView<String> User_GroupList;

    @FXML
    private ListView<String> User_NamesList;

    @FXML
    private Button S2_CheckProjectButton;

    @FXML
    private Button PreS_NextButton1;

    @FXML
    private Pane S2_Manage_AddScene;

    @FXML
    private Button AddScene_AddButton;

    @FXML
    private TextField AddScene_InputCount;

    @FXML
    private TextField AddScene_InputGroupName;

    @FXML
    private ListView<String> AddScene_GroupList;

    @FXML
    private Pane AddScene_Scene1;

    @FXML
    private TextField AddScene_T_InputName;

    @FXML
    private TextField AddScene_T_InputSecName;

    @FXML
    private TextField AddScene_T_InputTheme;

    @FXML
    private Label AddScene_S_LabelCounter;

    @FXML
    private Button AddScene_NextStudButton;

    @FXML
    private Pane AddScene_Scene2;

    @FXML
    private TextField AddScene_T_InputBaseDedline;

    @FXML
    private TextField AddScene_T_InputConceptDate;

    @FXML
    private TextField AddScene_T_InputBaseFuncDate;

    @FXML
    private TextField AddScene_T_InputAddFuncDate;

    @FXML
    private TextField AddScene_T_InputDocFuncDate;

    @FXML
    private Pane Manage_SceneForManaging1;

    @FXML
    private ListView<String> Manage_M_ListOfGroups1;

    @FXML
    private ListView<String> Manage_M_ListOfUsers1;

    @FXML
    private Button Manage_M_NextButton1;

    @FXML
    private Label Manage_M_LablThemeInfo1;

    @FXML
    private Button S2_ManageButton;

    @FXML
    private Button Manage_GoToManageSceneButton;

    @FXML
    private Pane Manage_SceneForManaging2;

    @FXML
    private TextField Upd_NameField;

    @FXML
    private TextField Upd_SecNameField;

    @FXML
    private Label Upd_IdLabl;

    @FXML
    private TextField Upd_GroupNumber;

    @FXML
    private TextField Upd_ThemeName;

    @FXML
    private TextField Upd_Conc_DedlineField;

    @FXML
    private TextField Upd_Conc_DedRecField;

    @FXML
    private TextField Upd_Conc_MarkField;

    @FXML
    private TextField Upd_FxBase_DedlineField;

    @FXML
    private TextField Upd_FxBase_DedRecField;

    @FXML
    private TextField Upd_FxBase_MarkField;

    @FXML
    private TextField Upd_FxAdd_DedlineField;

    @FXML
    private TextField Upd_FxAdd_DedRecField;

    @FXML
    private TextField Upd_FxAdd_MarkField;

    @FXML
    private TextField Upd_Doc_DedlineField;

    @FXML
    private TextField Upd_Doc_DedRecField;

    @FXML
    private TextField Upd_Doc_MarkField;

    @FXML
    private Label Upd_MarkInfo2;

    @FXML
    private Label Upd_MarkInfo3;

    @FXML
    private Label Upd_MarkInfo4;

    @FXML
    private Label Upd_DateFormatInfoLabl;

    @FXML
    private Label Upd_MarkInfo1;

    @FXML
    private TextField Upd_PassedSections;

    @FXML
    private TextField Upd_TotalMark;

    @FXML
    private Button Upd_SectCheckButton;

    @FXML
    private Button Upd_TotMarkCheckButton;

    @FXML
    private Button Upd_EndProject;

    @FXML
    private Button Upd_UpdateProject;

    @FXML
    private ListView<String> Upd_GroupList;

    @FXML
    private Button Upd_ConfirmGroupFromList;

    @FXML
    private Label Upd_DedlineLabl;

    @FXML
    private Pane Manage_EndByReadyScene;

    @FXML
    private ListView<String> ER_ListOfReadyUsers;

    @FXML
    private Button ER_EndProjectButton;

    @FXML
    private Button Manage_GoToEndScene;

    @FXML
    private Button ReportCreateButton;

    @FXML
    private Pane Manage_PasswordPanel;

    @FXML
    private Button Pas_PasEditButton;

    @FXML
    private TextField Pas_PasEditField;

    @FXML
    private Button S2_PassButton;

    @FXML
    private Label Pass_UnVisLabl;

    //Default visible
    void DefaultScenesVis()
    {
        PreCheck_Scene.setVisible(false);
        Check_Scene.setVisible(false);
        Manage_Scene.setVisible(false);
        Manage_PasswordPanel.setVisible(false);
        AddSceneVis();
        ManageMVis();
    }
    //ManageScene Visibles
    void ManageSceneVis()
    {
        AddSceneVis();
        ManageMVis();
        S2_Manage_AddScene.setVisible(false);
        Manage_EndByReadyScene.setVisible(false);
    }
    //AddScene visibles
    void AddSceneVis()
    {
        ManageMVis();
        AddScene_Scene1.setVisible(false);
        AddScene_Scene2.setVisible(false);
    }
    //ManageMScene Visibles
    void ManageMVis()
    {
        Manage_SceneForManaging1.setVisible(false);
        Manage_SceneForManaging2.setVisible(false);
    }
    //nulls
    void PMNulls()
    {
        AddingCouner=1;
        GrpCounter=0;

        AddingM_D_Date1="";
        AddingM_D_Date2="";
        AddingM_D_Date3="";
        AddingM_D_Date4="";
        AddingM_D_Date5="";

        AddingGroupName="";

        Date1Check=false;
        Date2Check=false;
        Date3Check=false;
        Date4Check=false;
        Date5Check=false;
    }
    //methods
    void DefaultVarInitPM()
    {
        Send_SearchGroup="";
    }
    //UserPanel complete action
    @FXML
    void NextButton1_Action(ActionEvent event) throws SQLException {
        GoSearchForUserInfo();
    }
    //proc for complet action
    void GoSearchForUserInfo() throws SQLException {
        Send_SearchNamesString=User_NamesList.getSelectionModel().getSelectedItem();
        Send_SearchGroup=User_GroupList.getSelectionModel().getSelectedItem();

        ObservableList<String> TemporContainerSet = FXCollections.observableArrayList();

        String TempStr="";
        if (!Send_SearchGroup.isEmpty() && !Send_SearchNamesString.isEmpty())
        {
            S2_Methods d=new S2_Methods();
            ResultSet RecInfoPack = d.LoadInfoAboutUser(Send_SearchGroup,Send_SearchNamesString);

            DefaultScenesVis();
            Check_Scene.setVisible(true);

            int columns = RecInfoPack.getMetaData().getColumnCount();
            while (RecInfoPack.next()) {
                for (int i = 1; i <= columns; i++)
                {
                    TempStr = RecInfoPack.getString(i);
                    TemporContainerSet.add(TempStr);
                }
            }
            //Load all info from set into lables
            Labl_NameInf.setText(TemporContainerSet.get(1)); //FirstName
            Labl_SecNameInf.setText(TemporContainerSet.get(2)); //SecondName
            Labl_ThemeCompilInfo.setText(Const.GUI_ThemeText+TemporContainerSet.get(3)); //Theme
            //Compare Date to show alert
            Date TempCurrentDate = d.GetCurrentDate();
            Date TempCompareDate = d.ConvertDateFromString(TemporContainerSet.get(5));
            boolean isDateBefore = TempCompareDate.before(TempCurrentDate);
            if (isDateBefore==true)
            {
                //create alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Внимание!");
                alert.setContentText("Похоже, вы просрочили срок сдачи курсовой");
                alert.showAndWait();
            }
            Labl_BaseDedline.setText(TemporContainerSet.get(5)); //Base Dedline
            Labl_ConceptDedline.setText(TemporContainerSet.get(6)); //Concept Date end
            Labl_ConceptDedlineRec.setText(TemporContainerSet.get(7)); //Concept Date rec
            Labl_ConceptDedlineMark.setText(TemporContainerSet.get(8)); //Concept Mark
            Labl_FuncBaseDedline.setText(TemporContainerSet.get(9)); //Base Date end
            Labl_FuncBaseDedlineRec.setText(TemporContainerSet.get(10)); //Base Date rec
            Labl_FuncBaseDedlineMark.setText(TemporContainerSet.get(11)); //Base Mark
            Labl_FuncAddDedline.setText(TemporContainerSet.get(12)); //Add Date
            Labl_FuncAddDedlineRec.setText(TemporContainerSet.get(13)); //Add Date rec
            Labl_FuncAddDedlineMark.setText(TemporContainerSet.get(14)); //Add Mark
            Labl_DocDedline.setText(TemporContainerSet.get(15)); //Doc Date
            Labl_DocDedlineRec.setText(TemporContainerSet.get(16)); //Doc Date rec
            Labl_DocMark.setText(TemporContainerSet.get(17)); //Doc Mark
            Labl_PassedCount.setText(Const.GUI_PassedText+TemporContainerSet.get(18)); //Passed Sections
            Labl_TotalMark.setText(TemporContainerSet.get(19)); //TotalMark
         }
    }
    void CurentUserShow() throws IOException {
        S2_Methods here=new S2_Methods();
        String toGUIUs=here.GetCurrentUserfromROM();
        GUIUserLable.setText(toGUIUs);
    }
    //Close Project
    @FXML
    void CloseProjectOperation1(ActionEvent event) {
        String[] SplitPassValues = Labl_PassedCount.getText().split(":");
        String[] SplitTheme = Labl_ThemeCompilInfo.getText().split(":");
        if (Integer.parseInt(SplitPassValues[1])!=4)
        {
            Alert alertee = new Alert(Alert.AlertType.INFORMATION);
            alertee.setTitle("Внимание!");
            alertee.setContentText("Вы не можете оставить запрос на завершение курсовой. Вы не прошли или не получили удовлетворительную оценку по всем этапам");
            alertee.showAndWait();
        }
        else
        {
            S2_Methods mToIns=new S2_Methods();
            mToIns.InsertingReady(SplitPassValues[1],Labl_NameInf.getText(),Labl_SecNameInf.getText(),SplitTheme[1]);
        }
    }
    //Go to User Panel
    @FXML
    void CheckProjectButton_Action(ActionEvent event) throws SQLException {
        DefaultScenesVis();
        CP_Load1();
        PreCheck_Scene.setVisible(true);
    }
    //methods for loading groups
    void CP_Load1() throws SQLException {

        String GroupTemp = "";
        ObservableList<String> GroupSetLoad = FXCollections.observableArrayList();

        S2_Methods b = new S2_Methods();
        ResultSet GroupRez = b.LoadGroupToList();

        int columns = GroupRez.getMetaData().getColumnCount();

        while (GroupRez.next()) {
            for (int i = 1; i <= columns; i++) {
                GroupTemp = GroupRez.getString(i);
                GroupSetLoad.add(GroupTemp);
            }
        }
        User_GroupList.setItems(GroupSetLoad);
    }
    //get user info
    @FXML
    void GroupList_MouseClicked1(MouseEvent event) throws SQLException {
        String UserNameTemp="";
        ObservableList<String> UserSetLoad = FXCollections.observableArrayList();
             Send_SearchGroup=User_GroupList.getSelectionModel().getSelectedItem();
             if (Send_SearchGroup !="")
             {
                 S2_Methods c=new S2_Methods();
                 ResultSet User1Rez=c.LoadUserInformation1(Send_SearchGroup);
                 ResultSet User2Rez=c.LoadUserInformation2(Send_SearchGroup);

                 int columns1 = User1Rez.getMetaData().getColumnCount();
                 int columns2 = User2Rez.getMetaData().getColumnCount();

                 //check columns values
                 if (columns1==columns2)
                 {
                     while (User1Rez.next() && User2Rez.next()) {
                         for (int i = 1; i <= columns1; i++) {
                             UserNameTemp = User1Rez.getString(i)+" "+User2Rez.getString(i);
                             UserSetLoad.add(UserNameTemp);
                         }
                     }
                     User_NamesList.setItems(UserSetLoad);
                 }
             }
    }
    //Set UserName to Scene
    void SetCurrentUserforScene(String Rec_UserText)
    {
        GUIUserLable.setText(Rec_UserText);
    }
    //Go to Manage Panel
    @FXML
    void S2_ManageButtonAction(ActionEvent event) {
        CheckAccessUser();
    }
    //Check for access
    void CheckAccessUser()
    {
        S2_Methods ch=new S2_Methods();
        String AccessValue=ch.getAccessofUser(GUIUserLable.getText());
        if (AccessValue.equals("0"))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Внимание!");
            alert.setContentText("У вас нет доступа");
            alert.showAndWait();
        }
        else
        {
            DefaultScenesVis();
            Manage_Scene.setVisible(true);
            ManageSceneVis();
        }
    }
    //go to add panel(Admin)
    @FXML
    void Manage_AddProjectsButtonAction(ActionEvent event)throws SQLException {
        ManageSceneVis();
        AddSceneVis();
        PMNulls();
        S2_Manage_AddScene.setVisible(true);
        //load info
        Manage_AddP_GroupListLoad();
        AddScene_InputCount.setVisible(true);
        AddScene_InputGroupName.setVisible(true);
    }
    //load groups to addproject scene
    void Manage_AddP_GroupListLoad() throws SQLException {
        String GroupTemp = "";
        ObservableList<String> GroupSetLoading = FXCollections.observableArrayList();

        S2_Methods b = new S2_Methods();
        ResultSet GroupRez = b.LoadGroupToList();

        int columns = GroupRez.getMetaData().getColumnCount();

        while (GroupRez.next()) {
            for (int i = 1; i <= columns; i++) {
                GroupTemp = GroupRez.getString(i);
                GroupSetLoading.add(GroupTemp);
            }
        }
        AddScene_GroupList.setItems(GroupSetLoading);
    }
    @FXML
    void AddScene_AddButtonAction(ActionEvent event)
    {
        AddingGroupName=AddScene_InputGroupName.getText();
        String AddingCount=AddScene_InputCount.getText();
        try {
            if (AddingGroupName.equals("") && AddingCount.equals(""))
            {
                Alert alertaa = new Alert(Alert.AlertType.INFORMATION);
                alertaa.setTitle("Внимание!");
                alertaa.setContentText("Вы не ввели значения");
                alertaa.showAndWait();
                }
            else
                {
                    //check for int value inputted
                    S2_Methods chk=new S2_Methods();
                    boolean IsCountDigi=chk.isNumeric(AddingCount);
                    if (IsCountDigi==false)
                    {
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Ошибка!");
                        alerta.setContentText("Вы ввели не численное значение");
                        alerta.showAndWait();
                    }
                    else
                    {
                        int GetIntCountValue = Integer.valueOf(AddingCount);
                        if (GetIntCountValue > 30)
                        {
                            Alert alertb = new Alert(Alert.AlertType.INFORMATION);
                            alertb.setTitle("Внимание!");
                            alertb.setContentText("Максимальное количество студентов-30. Или у вас как-то иначе?");
                            alertb.showAndWait();
                        }
                        else
                        {
                            //go to setting new project
                            AddingProjectProc(GetIntCountValue);
                        }
                    }
             }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //proc to handle actions for adding
    void AddingProjectProc(int CountOfStuds)
    {
        GrpCounter=CountOfStuds;
        AddScene_S_LabelCounter.setText(Integer.toString(1));
        //Set used fields to null
        AddScene_InputGroupName.setText(null);
        AddScene_InputCount.setText(null);
        AddSceneVis();
        AddScene_Scene1.setVisible(true);
        AddScene_Scene2.setVisible(true);
    }
    @FXML
    void AddScene_NextStudButtonAction(ActionEvent event) {
        S2_Methods ths=new S2_Methods();
        System.out.println(AddingGroupName);
        if (AddingCouner==1)
        {
            //Send dates to vars
            AddingM_D_Date1=AddScene_T_InputBaseDedline.getText();

            AddingM_D_Date2=AddScene_T_InputConceptDate.getText();
            AddingM_D_Date3=AddScene_T_InputBaseFuncDate.getText();
            AddingM_D_Date4=AddScene_T_InputAddFuncDate.getText();
            AddingM_D_Date5=AddScene_T_InputDocFuncDate.getText();

            AddScene_Scene2.setVisible(false);
            Date1Check=ths.isDate(AddingM_D_Date1);
            Date2Check=ths.isDate(AddingM_D_Date2);
            Date3Check=ths.isDate(AddingM_D_Date3);
            Date4Check=ths.isDate(AddingM_D_Date4);
            Date5Check=ths.isDate(AddingM_D_Date5);
        }
        if (Date1Check!=false && Date2Check!=false && Date3Check!=false && Date4Check!=false && Date5Check!=false)
        {
            //get inputed info
            String ToInName=AddScene_T_InputName.getText();
            String ToInSecName=AddScene_T_InputSecName.getText();
            String ToInTheme=AddScene_T_InputTheme.getText();
            //check for empty
            if (ToInName.equals("") && ToInSecName.equals("") && ToInTheme.equals(""))
            {
                Alert alertq = new Alert(Alert.AlertType.INFORMATION);
                alertq.setTitle("Ошибка!");
                alertq.setContentText("Проверьте паля Имени, Фамилии, Темы");
                alertq.showAndWait();
            }
            else
            {
                if (!AddingM_D_Date1.equals("") && !AddingM_D_Date2.equals("") && !AddingM_D_Date3.equals("") && !AddingM_D_Date4.equals("") && !AddingM_D_Date5.equals(""))
                {
                    //set inputsvis to false
                    AddScene_InputCount.setVisible(false);
                    AddScene_InputGroupName.setVisible(false);

                    if (AddingCouner < GrpCounter+1)
                    {
                        //clear textfields
                        AddScene_T_InputName.setText("");
                        AddScene_T_InputSecName.setText("");
                        AddScene_T_InputTheme.setText("");
                        //insert new user
                        ProjectStudent InsStud=new ProjectStudent();
                        InsStud.setpFName(ToInName);
                        InsStud.setpSName(ToInSecName);
                        InsStud.setpTheme(ToInTheme);
                        InsStud.setpGroupNumber(AddingGroupName);
                        InsStud.setpDedLine(AddingM_D_Date1);
                        InsStud.setpConceptDedline(AddingM_D_Date2);
                        InsStud.setpConceptDedlineRec("00-00-0000");
                        InsStud.setpConceptMark("0");
                        InsStud.setpBaseFxDedLine(AddingM_D_Date3);
                        InsStud.setpBaseFxDedLineRec("00-00-0000");
                        InsStud.setpBaseFxMark("0");
                        InsStud.setpAddFxDedline(AddingM_D_Date4);
                        InsStud.setpAddFxDedlineRec("00-00-0000");
                        InsStud.setpAddFxMark("0");
                        InsStud.setpDocDedline(AddingM_D_Date5);
                        InsStud.setpDocDedlineRec("00-00-0000");
                        InsStud.setpDocMark("0");
                        InsStud.setpPassedSect("0");
                        InsStud.setpTotalMark("0");
                        //send created obj
                        DatabaseHandle dbHandel=new DatabaseHandle();
                        dbHandel.InsertProject(InsStud);
                    }
                    AddScene_S_LabelCounter.setText(Integer.toString(AddingCouner+1));
                    AddingCouner++;
                    if (AddingCouner==GrpCounter)
                    {
                        Alert alertf = new Alert(Alert.AlertType.INFORMATION);
                        alertf.setTitle("Внимание!");
                        alertf.setContentText("Все проекты добавлены!");
                        alertf.showAndWait();
                        AddScene_S_LabelCounter.setText(Integer.toString(1));
                        AddSceneVis();
                    }
                }
                else
                {
                    AddScene_Scene2.setVisible(true);
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Ошибка!");
                    alerta.setContentText("Вы не ввели все даты");
                    alerta.showAndWait();
                }
            }
        }
        else
        {
            AddScene_Scene2.setVisible(true);
            Alert alerte = new Alert(Alert.AlertType.INFORMATION);
            alerte.setTitle("Ошибка!");
            alerte.setContentText("Вы неверно ввели даты");
            alerte.showAndWait();
        }
    }
    //clear update panel
    void ClearUpdSceneField()
    {
        Upd_NameField.clear();
        Upd_SecNameField.clear();
        Upd_GroupNumber.clear();
        Upd_ThemeName.clear();

        Upd_PassedSections.clear();
        Upd_TotalMark.clear();

        Upd_Conc_DedlineField.clear();
        Upd_Conc_DedRecField.clear();
        Upd_Conc_MarkField.clear();

        Upd_FxBase_DedlineField.clear();
        Upd_FxBase_DedRecField.clear();
        Upd_FxBase_MarkField.clear();

        Upd_FxAdd_DedlineField.clear();
        Upd_FxAdd_DedRecField.clear();
        Upd_FxBase_MarkField.clear();

        Upd_Doc_DedlineField.clear();
        Upd_Doc_DedRecField.clear();
        Upd_Doc_MarkField.clear();
    }
    //Managing User Table Scene procs
    @FXML
    void Manage_GoToManageSceneButtonAction1(ActionEvent event) throws SQLException {
        ManageSceneVis();
        AddSceneVis();
        Manage_SceneForManaging1.setVisible(true);
        Manage_M_LablThemeInfo1.setText(Const.GUI_M_ThemeNull);

        String GroupTemp = "";
        ObservableList<String> GroupSetLoad = FXCollections.observableArrayList();

        S2_Methods b = new S2_Methods();
        ResultSet GroupRez = b.LoadGroupToList();

        int columns = GroupRez.getMetaData().getColumnCount();

        while (GroupRez.next()) {
            for (int i = 1; i <= columns; i++) {
                GroupTemp = GroupRez.getString(i);
                GroupSetLoad.add(GroupTemp);
            }
        }
        Manage_M_ListOfGroups1.setItems(GroupSetLoad);
    }
    @FXML
    void Manage_M_ListOfGroups1Clicked(MouseEvent event) throws SQLException {
        Manage_M_LablThemeInfo1.setText(Const.GUI_M_ThemeNull);
        String UserNameTemp="";
        ObservableList<String> UserSetLoad = FXCollections.observableArrayList();
        Send_SearchGroup=Manage_M_ListOfGroups1.getSelectionModel().getSelectedItem();
        if (Send_SearchGroup !="")
        {
            S2_Methods c=new S2_Methods();
            ResultSet User1Rez=c.LoadUserInformation1(Send_SearchGroup);
            ResultSet User2Rez=c.LoadUserInformation2(Send_SearchGroup);

            int columns1 = User1Rez.getMetaData().getColumnCount();
            int columns2 = User2Rez.getMetaData().getColumnCount();

            //check columns values
            if (columns1==columns2)
            {
                while (User1Rez.next() && User2Rez.next()) {
                    for (int i = 1; i <= columns1; i++) {
                        UserNameTemp = User1Rez.getString(i)+" "+User2Rez.getString(i);
                        UserSetLoad.add(UserNameTemp);
                    }
                }
                Manage_M_ListOfUsers1.setItems(UserSetLoad);
            }
        }
    }
    @FXML
    void Manage_M_ListOfUsers1Clicked(MouseEvent event) throws SQLException {
        String ListOfUsersTemp=Manage_M_ListOfUsers1.getSelectionModel().getSelectedItem();
        String ListOfGroupsTem=Manage_M_ListOfGroups1.getSelectionModel().getSelectedItem();

        String TempStr="";

        if (!Manage_M_ListOfUsers1.getSelectionModel().isEmpty() && !Manage_M_ListOfGroups1.getSelectionModel().isEmpty())
        {
            S2_Methods thM=new S2_Methods();
            ResultSet packInfoTemp=thM.LoadInfoAboutUser(ListOfGroupsTem,ListOfUsersTemp);

            ObservableList<String> TempContainerSet = FXCollections.observableArrayList();

            int columns = packInfoTemp.getMetaData().getColumnCount();
            while (packInfoTemp.next()) {
                for (int i = 1; i <= columns; i++)
                {
                    TempStr = packInfoTemp.getString(i);
                    TempContainerSet .add(TempStr);
                }
            }
            if (!TempContainerSet.isEmpty()) {
                Manage_M_LablThemeInfo1.setText(TempContainerSet.get(3));
            }
        }
    }
    //after select proc
    @FXML
    void Manage_M_NextButton1Action(ActionEvent event) throws SQLException {
        String TempThemeStr=Manage_M_LablThemeInfo1.getText();
        if (TempThemeStr.equals(""))
        {
            Alert alertfe = new Alert(Alert.AlertType.INFORMATION);
            alertfe.setTitle("Ошибка!");
            alertfe.setContentText("Вы не выбрали учащегося!");
            alertfe.showAndWait();
        }
        else
        {
            String ListOfUsersTempo=Manage_M_ListOfUsers1.getSelectionModel().getSelectedItem();
            String ListOfGroupsTempo=Manage_M_ListOfGroups1.getSelectionModel().getSelectedItem();
            String TempStr="";
            if ( !Manage_M_ListOfGroups1.getSelectionModel().isEmpty() && !Manage_M_ListOfUsers1.getSelectionModel().isEmpty())
            {
                S2_Methods thM=new S2_Methods();
                ResultSet packInfoTempo=thM.LoadInfoAboutUser(ListOfGroupsTempo,ListOfUsersTempo);

                ObservableList<String> TempContainerSet = FXCollections.observableArrayList();

                int columns = packInfoTempo.getMetaData().getColumnCount();
                while (packInfoTempo.next()) {
                    for (int i = 1; i <= columns; i++)
                    {
                        TempStr = packInfoTempo.getString(i);
                        TempContainerSet .add(TempStr);
                    }
                }
                //Go to next scene
                ManageMVis();
                //clear lables before fill
                ClearUpdSceneField();
                //load info to lables
                Upd_IdLabl.setText(TempContainerSet.get(0));
                Upd_NameField.setText(TempContainerSet.get(1));
                Upd_SecNameField.setText(TempContainerSet.get(2));
                Upd_ThemeName.setText(TempContainerSet.get(3));
                Upd_GroupNumber.setText(TempContainerSet.get(4));
                //Main dedline
                Upd_DedlineLabl.setText(TempContainerSet.get(5));
                //Concept dates
                Upd_Conc_DedlineField.setText(TempContainerSet.get(6));
                Upd_Conc_DedRecField.setText(TempContainerSet.get(7));
                Upd_Conc_MarkField.setText(TempContainerSet.get(8));
                //Base dates
                Upd_FxBase_DedlineField.setText(TempContainerSet.get(9));
                Upd_FxBase_DedRecField.setText(TempContainerSet.get(10));
                Upd_FxBase_MarkField.setText(TempContainerSet.get(11));
                //Add dates
                Upd_FxAdd_DedlineField.setText(TempContainerSet.get(12));
                Upd_FxAdd_DedRecField.setText(TempContainerSet.get(13));
                Upd_FxAdd_MarkField.setText(TempContainerSet.get(14));
                //Doc dates
                Upd_Doc_DedlineField.setText(TempContainerSet.get(15));
                Upd_Doc_DedRecField.setText(TempContainerSet.get(16));
                Upd_Doc_MarkField.setText(TempContainerSet.get(17));
                //Sections and marks
                Upd_PassedSections.setText(TempContainerSet.get(18));
                Upd_TotalMark.setText(TempContainerSet.get(19));
                //list load
                LoadGroupsToUpdatePanel();
                Manage_SceneForManaging2.setVisible(true);
            }
        }
    }
    //load groups,again,yes
    void LoadGroupsToUpdatePanel() throws SQLException {
        String GroupTemp = "";
        ObservableList<String> GroupSetLoad = FXCollections.observableArrayList();

        S2_Methods b = new S2_Methods();
        ResultSet GroupRez = b.LoadGroupToList();

        int columns = GroupRez.getMetaData().getColumnCount();

        while (GroupRez.next()) {
            for (int i = 1; i <= columns; i++) {
                GroupTemp = GroupRez.getString(i);
                GroupSetLoad.add(GroupTemp);
            }
        }
        Upd_GroupList.setItems(GroupSetLoad);
    }
    //Manage buttons handler
    @FXML
    void Upd_ConfirmGroupFromListAction(ActionEvent event) {
        if (!Upd_GroupList.getSelectionModel().isEmpty())
        {
            String getGrpTem=Upd_GroupList.getSelectionModel().getSelectedItem();
            Alert alertcc = new Alert(Alert.AlertType.CONFIRMATION);
            alertcc.setTitle("Delete File");
            alertcc.setHeaderText("Вы действительно хотите изменить группу?");
            alertcc.setContentText("Прошлая группа"+" "+Upd_GroupNumber.getText());

            // option != null.
            Optional<ButtonType> option = alertcc.showAndWait();

            if (option.get() == null) {
                //null
            } else if (((Optional) option).get() == ButtonType.OK) {
                Upd_GroupNumber.setText(getGrpTem);
            } else if (option.get() == ButtonType.CANCEL) {
                //null
            } else {
                //null
            }
        }
        else
        {
            Alert alertes = new Alert(Alert.AlertType.INFORMATION);
            alertes.setTitle("Ошибка!");
            alertes.setContentText("Вы не выбрали группу");
            alertes.showAndWait();
        }
    }
    //match passed section
    @FXML
    void Upd_SectCheckButtonAction(ActionEvent event) {
        S2_Methods cchk=new S2_Methods();
        int CountOfPassed=0;
        //get booleans
        boolean check1=cchk.isNumeric(Upd_Conc_MarkField.getText());
        boolean check2=cchk.isNumeric(Upd_FxBase_MarkField.getText());
        boolean check3=cchk.isNumeric(Upd_FxAdd_MarkField.getText());
        boolean check4=cchk.isNumeric(Upd_Doc_MarkField.getText());
        if (check1==false || check2==false || check3==false || check4==false)
        {
            Alert alerseqq = new Alert(Alert.AlertType.INFORMATION);
            alerseqq.setTitle("Ошибка!");
            alerseqq.setContentText("В полях оценок присуствует не числовое значение");
            alerseqq.showAndWait();
        }
        else
        {
            int TMark1=Integer.parseInt(Upd_Conc_MarkField.getText());
            int TMark2=Integer.parseInt(Upd_FxBase_MarkField.getText());
            int TMark3=Integer.parseInt(Upd_FxAdd_MarkField.getText());
            int TMark4=Integer.parseInt(Upd_Doc_MarkField.getText());
            if (TMark1>=0 && TMark1<4 && TMark2>=0 && TMark2 <4 && TMark3>=0 && TMark3<4 && TMark4>=0 && TMark4<4)
            {
                //check
                if (TMark1>=1)
                {
                    CountOfPassed++;
                }
                if (TMark2>=2)
                {
                    CountOfPassed++;
                }
                if (TMark3>=2)
                {
                    CountOfPassed++;
                }
                if (TMark4>=2)
                {
                    CountOfPassed++;
                }
                if (CountOfPassed<5)
                {
                    Upd_PassedSections.setText(String.valueOf(CountOfPassed));
                    Alert alt = new Alert(Alert.AlertType.INFORMATION);
                    alt.setTitle("Результат");
                    alt.setContentText("Данные пересчитаны");
                    alt.showAndWait();
                }
            }
            else
            {
                Alert aaae = new Alert(Alert.AlertType.INFORMATION);
                aaae.setTitle("Ошибка!");
                aaae.setContentText("Неверные значения в полях Оценка. Нажмите на знак вопроса напротив полей чтобы узнать доп.информацию");
                aaae.showAndWait();
            }
        }
    }
    //Mark value get
    @FXML
    void Upd_TotMarkCheckButtonAction(ActionEvent event) {
        S2_Methods cchk=new S2_Methods();
        int CountOfPassed=0;
        int TSumMark=0;
        int TInpMark=0;
        //get booleans
        boolean check1=cchk.isNumeric(Upd_Conc_MarkField.getText());
        boolean check2=cchk.isNumeric(Upd_FxBase_MarkField.getText());
        boolean check3=cchk.isNumeric(Upd_FxAdd_MarkField.getText());
        boolean check4=cchk.isNumeric(Upd_Doc_MarkField.getText());
        if (check1==false || check2==false || check3==false || check4==false)
        {
            Alert alerseqq = new Alert(Alert.AlertType.INFORMATION);
            alerseqq.setTitle("Ошибка!");
            alerseqq.setContentText("В полях оценок присуствует не числовое значение");
            alerseqq.showAndWait();
        }
        else
        {
            int TMark1=Integer.parseInt(Upd_Conc_MarkField.getText());
            int TMark2=Integer.parseInt(Upd_FxBase_MarkField.getText());
            int TMark3=Integer.parseInt(Upd_FxAdd_MarkField.getText());
            int TMark4=Integer.parseInt(Upd_Doc_MarkField.getText());
            if (TMark1>=0 && TMark1<4 && TMark2>=0 && TMark2 <4 && TMark3>=0 && TMark3<4 && TMark4>=0 && TMark4<4)
            {
                //check
                if (TMark1>=1)
                {
                    CountOfPassed++;
                }
                if (TMark2>=2)
                {
                    CountOfPassed++;
                }
                if (TMark3>=2)
                {
                    CountOfPassed++;
                }
                if (TMark4>=2)
                {
                    CountOfPassed++;
                }
                //match mark value
                TSumMark=TMark1+TMark2+TMark3+TMark4;
                if (CountOfPassed<=3)
                {
                    if (TSumMark>6)
                    {
                        TInpMark=3;
                    }
                    if (TSumMark == 0)
                    {
                        TInpMark = 0;
                    }
                    if (TSumMark == 1 || TSumMark == 2) {
                        TInpMark = 1;
                    }
                    if (TSumMark == 3 || TSumMark == 4) {
                        TInpMark = 2;
                    }
                    if (TSumMark == 5 || TSumMark == 6) {
                        TInpMark = 3;
                    }
                }
                if (CountOfPassed==4)
                {
                    if (TSumMark==7)
                    {
                        TInpMark=4;
                    }
                    if (TSumMark==8)
                    {
                        TInpMark=5;
                    }
                    if (TSumMark==9)
                    {
                        TInpMark=6;
                    }
                    if (TSumMark==10)
                    {
                        TInpMark=7;
                    }
                    if (TSumMark==11)
                    {
                        TInpMark=8;
                    }
                    if (TSumMark==12)
                    {
                        TInpMark=10;
                        Alert alertcc = new Alert(Alert.AlertType.CONFIRMATION);
                        alertcc.setTitle("Решение об оценке");
                        alertcc.setHeaderText("Пользователь прошел все этапы курсового на отлично");
                        alertcc.setContentText("Пользователю выставлена оценка 10, если вы желаете выставить оценку 9-нажмите кнопку ОТМЕНА");

                        // option != null.
                        Optional<ButtonType> option = alertcc.showAndWait();

                        if (option.get() == null) {
                            //null
                        } else if (((Optional) option).get() == ButtonType.OK) {
                            //null
                        } else if (option.get() == ButtonType.CANCEL) {
                            TInpMark=9;
                        } else {
                            //null
                        }
                    }
                }
                Upd_TotalMark.setText(String.valueOf(TInpMark));
                Alert alta = new Alert(Alert.AlertType.INFORMATION);
                alta.setTitle("Результат");
                alta.setContentText("Данные пересчитаны");
                alta.showAndWait();
            }
            else
            {
                Alert aaae = new Alert(Alert.AlertType.INFORMATION);
                aaae.setTitle("Ошибка!");
                aaae.setContentText("Неверные значения в полях Оценка. Нажмите на знак вопроса напротив полей чтобы узнать доп.информацию");
                aaae.showAndWait();
            }
        }
    }
    //get info about formats
    @FXML
    void Upd_DateFormatInfoLablAction(MouseEvent event) {
        Alert aaae = new Alert(Alert.AlertType.INFORMATION);
        aaae.setTitle("Информация");
        aaae.setContentText("Ввод дат производиться в формате dd-mm-yyyy,"+'\n'+"где dd-день, mm-месяц, yyyy-год");
        aaae.showAndWait();
    }
    //get mark info format
    @FXML
    void Upd_MarkInfoAction(MouseEvent event) {
        Alert aaad = new Alert(Alert.AlertType.INFORMATION);
        aaad.setTitle("Информация");
        aaad.setContentText("Оценки считаются следующим образом: 0-невыполнено, 1-базовое выполнение, 2-техническое выполнение, 3-полное выполнение." +'\n'+
                "За этап концептуального прототипа нужно получить не менее 1," +'\n'+
                "За этап базовых функций нужно получить не менее 2," +'\n'+
                "За этап доп функций нужпо получить не менее 2," +'\n'+
                "За этап пояснительной записки нужно поулчить не менее 2");
        aaad.showAndWait();
    }
    //end project
    @FXML
    void Upd_EndProjectAction(ActionEvent event)
    {
        Alert alertcc = new Alert(Alert.AlertType.CONFIRMATION);
        alertcc.setTitle("Внимание!");
        alertcc.setHeaderText("Вы действительно хотите закрыть курсовую?");
        alertcc.setContentText("Курсовая сохранится с текущими данными," +'\n'+"если учащийся не сдал наположительную-это уже будет не изменить" +'\n'+"Все данные будут отправлены в архив");

        // option != null.
        Optional<ButtonType> option = alertcc.showAndWait();

        if (option.get() == null) {
            //null
        } else if (((Optional) option).get() == ButtonType.OK) {
            UpdEndProjectProc();
        } else if (option.get() == ButtonType.CANCEL) {
            //null
        } else {
            //null
        }
    }
    //update info
    @FXML
    void Upd_UpdateProjectAction(ActionEvent event) {
        S2_Methods ah = new S2_Methods();
        DatabaseHandle dbthHandl=new DatabaseHandle();

        //variables
        String U_Id= Upd_IdLabl.getText();

        String U_FName= Upd_NameField.getText();
        String U_SecName=Upd_SecNameField.getText();
        String U_Theme=Upd_ThemeName.getText();
        String U_Group=Upd_GroupNumber.getText();

        String U_PassSect=Upd_PassedSections.getText();
        String U_TotMark=Upd_TotalMark.getText();

        String U_BaseDedline=Upd_DedlineLabl.getText();

        String U_Conc_Ded=Upd_Conc_DedlineField.getText();
        String U_Conc_DedRec=Upd_Conc_DedRecField.getText();
        String U_Conc_Mark=Upd_Conc_MarkField.getText();

        String U_FxBase_Ded=Upd_FxBase_DedlineField.getText();
        String U_FxBase_DedRec=Upd_FxBase_DedRecField.getText();
        String U_FxBase_Mark=Upd_FxBase_MarkField.getText();

        String U_AddFx_Ded=Upd_FxAdd_DedlineField.getText();
        String U_AddFx_DedRec=Upd_FxAdd_DedRecField.getText();
        String U_AddFx_Mark=Upd_FxAdd_MarkField.getText();

        String U_Doc_Ded=Upd_Doc_DedlineField.getText();
        String U_Doc_DedRec=Upd_Doc_DedRecField.getText();
        String U_Doc_Mark=Upd_Doc_MarkField.getText();
        //check for emp
        if (!U_FName.equals("") && !U_SecName.equals("") && !U_Theme.equals("") && !U_Group.equals("") && !U_PassSect.equals("")
         && !U_TotMark.equals("") && !U_BaseDedline.equals("") && !U_Conc_Ded.equals("") && !U_Conc_DedRec.equals("") && !U_Conc_Mark.equals("")
            && !U_FxBase_Ded.equals("") && !U_FxBase_DedRec.equals("") && !U_FxBase_Mark.equals("") && !U_AddFx_Ded.equals("") && !U_AddFx_DedRec.equals("")
            && !U_AddFx_Mark.equals("") && !U_Doc_Ded.equals("") && !U_Doc_DedRec.equals("") && !U_Doc_Mark.equals(""))
        {
            //check for right dates
            boolean DateB=ah.isDate(U_BaseDedline); //Base Dedline
            //Concept
            boolean DateCD=ah.isDate(U_Conc_Ded);
            boolean DateCDR=ah.isDate(U_Conc_DedRec);
            //Basic
            boolean DateFBD=ah.isDate(U_FxBase_Ded);
            boolean DateFBDR=ah.isDate(U_FxBase_DedRec);
            //Add
            boolean DateAD=ah.isDate(U_AddFx_Ded);
            boolean DateADR=ah.isDate(U_AddFx_DedRec);
            //Docs
            boolean DateDD=ah.isDate(U_Doc_Ded);
            boolean DateDDR=ah.isDate(U_Doc_DedRec);
            if (DateB==false && DateCD==false && DateCDR==false && DateFBD==false && DateFBDR==false && DateAD==false && DateADR==false && DateDD==false && DateDDR==false)
            {
                Alert saaeff = new Alert(Alert.AlertType.INFORMATION);
                saaeff.setTitle("Ошибка");
                saaeff.setContentText("Даты вписаны неправильно. Нажмите на знак вопроса на панели с этапами для доп.информации");
                saaeff.showAndWait();
            }
            else
            {
                boolean Int1=false;
                boolean Int2=false; //Total mark
                boolean Int3=false;
                boolean Int4=false;
                boolean Int5=false;
                boolean Int6=false;
                //check for right values
                if (Integer.parseInt(U_PassSect)<=4 && Integer.parseInt(U_PassSect)>=0)
                {
                    Int1=true;
                }
                if (Integer.parseInt(U_TotMark)<=10 && Integer.parseInt(U_TotMark)>=0)
                {
                    Int2=true;
                }
                if (Integer.parseInt(U_Conc_Mark)<=3 && Integer.parseInt(U_Conc_Mark)>=0)
                {
                    Int3=true;
                }
                if (Integer.parseInt(U_FxBase_Mark)<=3 && Integer.parseInt(U_FxBase_Mark)>=0)
                {
                    Int4=true;
                }
                if (Integer.parseInt(U_AddFx_Mark)<=3 && Integer.parseInt(U_AddFx_Mark)>=0)
                {
                    Int5=true;
                }
                if (Integer.parseInt(U_Doc_Mark)<=3 && Integer.parseInt(U_Doc_Mark)>=0)
                {
                    Int6=true;
                }
                //check ints
                if (Int1==true && Int2==true && Int3==true && Int4==true && Int5==true && Int6==true)
                {
                    ProjectStudent tStud=new ProjectStudent();
                    tStud.setpFName(U_FName);
                    tStud.setpSName(U_SecName);
                    tStud.setpTheme(U_Theme);
                    tStud.setpGroupNumber(U_Group);
                    tStud.setpDedLine(U_BaseDedline);
                    tStud.setpConceptDedline(U_Conc_Ded);
                    tStud.setpConceptDedlineRec(U_Conc_DedRec);
                    tStud.setpConceptMark(U_Conc_Mark);
                    tStud.setpBaseFxDedLine(U_FxBase_Ded);
                    tStud.setpBaseFxDedLineRec(U_FxBase_DedRec);
                    tStud.setpBaseFxMark(U_FxBase_Mark);
                    tStud.setpAddFxDedline(U_AddFx_Ded);
                    tStud.setpAddFxDedlineRec(U_AddFx_DedRec);
                    tStud.setpAddFxMark(U_AddFx_Mark);
                    tStud.setpDocDedline(U_Doc_Ded);
                    tStud.setpDocDedlineRec(U_Doc_DedRec);
                    tStud.setpDocMark(U_Doc_Mark);
                    tStud.setpPassedSect(U_PassSect);
                    tStud.setpTotalMark(U_TotMark);
                    dbthHandl.UpdateProjectTable(tStud,U_Id);

                    Alert alertcc = new Alert(Alert.AlertType.CONFIRMATION);
                    alertcc.setTitle("Результат");
                    alertcc.setHeaderText("Данные изменены");
                    alertcc.setContentText("Если вы желаете закрыть окно-нажмите ОК, если желаете продолжить редактирование-ОТМЕНА");

                    // option != null.
                    Optional<ButtonType> option = alertcc.showAndWait();

                    if (option.get() == null) {
                        //null
                    } else if (((Optional) option).get() == ButtonType.OK) {
                        ManageMVis();
                    } else if (option.get() == ButtonType.CANCEL) {

                    } else {
                        //null
                    }
                }
                else
                {
                    Alert aaeff = new Alert(Alert.AlertType.INFORMATION);
                    aaeff.setTitle("Ошибка");
                    aaeff.setContentText("Неправильные значения числовых полей");
                    aaeff.showAndWait();
                }
            }
        }
        else
        {
            Alert aaeff = new Alert(Alert.AlertType.INFORMATION);
            aaeff.setTitle("Ошибка");
            aaeff.setContentText("Пустые поля");
            aaeff.showAndWait();
        }
    }
    //end proj proc
    void UpdEndProjectProc()
    {
        S2_Methods ah = new S2_Methods();
        DatabaseHandle dbthHandl=new DatabaseHandle();

        String E_FName=Upd_NameField.getText();
        String E_SecName=Upd_SecNameField.getText();
        String E_GrpTheme=Upd_ThemeName.getText();
        String E_TotMark=Upd_TotalMark.getText();

        String E_Id=Upd_IdLabl.getText();

        if (!E_FName.equals("") && !E_SecName.equals("") && !E_GrpTheme.equals("") && !E_TotMark.equals(""))
        {
            boolean MarkCheck=ah.isNumeric(E_TotMark);
            if (MarkCheck==true)
            {
                //delete
                dbthHandl.DeleteProject(E_Id);
                //insert
                dbthHandl.InsertingIntoArchive(E_FName,E_SecName,E_GrpTheme,E_TotMark);
                //show and close
                Alert aaefff = new Alert(Alert.AlertType.INFORMATION);
                aaefff.setTitle("Внимание!");
                aaefff.setContentText("Все операции завершены");
                aaefff.showAndWait();
                ManageMVis();
            }
            else
            {
                Alert aaeff = new Alert(Alert.AlertType.INFORMATION);
                aaeff.setTitle("Информация");
                aaeff.setContentText("Вы ввели не числа");
                aaeff.showAndWait();
            }
        }
        else
        {
            Alert aaef = new Alert(Alert.AlertType.INFORMATION);
            aaef.setTitle("Информация");
            aaef.setContentText("Значения пустые");
            aaef.showAndWait();
        }
    }
    //End ProjectByReady Scene procs
    @FXML
    void Manage_GoToEndSceneAction(ActionEvent event) {
        ManageSceneVis();
        Manage_EndByReadyScene.setVisible(true);
        LoadReadyList();

    }
    void LoadReadyList()
    {
        DatabaseHandle dbGtHandle=new DatabaseHandle();
        ObservableList<String> ReadySetLoad = FXCollections.observableArrayList();
        ObservableList<String> TempSetForTempSet = FXCollections.observableArrayList();
        ResultSet IdsSet=dbGtHandle.SelectIDSet();
        String TempID="";
        String TempStr="";
        int columns = 0;
        try {
            columns = IdsSet.getMetaData().getColumnCount();

            while (IdsSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    TempSetForTempSet.clear();
                    TempID = IdsSet.getString(i);
                    //Seach for tempID
                    ResultSet TempSet=dbGtHandle.SelectUserByID(TempID);
                    int columnss = TempSet.getMetaData().getColumnCount();
                    while (TempSet.next()) {
                        for (int j = 1; j <= columnss; j++) {
                            TempStr = TempSet.getString(j);
                            TempSetForTempSet.add(TempStr);
                        }
                    }
                    if (columnss==4)
                    {
                        ReadySetLoad.add(TempID+" "+TempSetForTempSet.get(0)+" "+TempSetForTempSet.get(1)+" "+TempSetForTempSet.get(2)+" "+TempSetForTempSet.get(3));
                    }
                }
            }
            ER_ListOfReadyUsers.setItems(ReadySetLoad);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ER_EndProjectButtonAction(ActionEvent event) throws SQLException {
        DatabaseHandle dbThEnd=new DatabaseHandle();
        ObservableList<String> TempSetF = FXCollections.observableArrayList();
        String TempStr="";
        if (!ER_ListOfReadyUsers.getSelectionModel().isEmpty())
        {
            String ER_TempStr=ER_ListOfReadyUsers.getSelectionModel().getSelectedItem();
            String[] StrSplitted = ER_TempStr.split(" ");
            ResultSet UserInfoPuck=dbThEnd.SelectUserByIDforInsert(StrSplitted[0]);
            int columnss = UserInfoPuck.getMetaData().getColumnCount();
            while (UserInfoPuck.next()) {
                for (int j = 1; j <= columnss; j++) {
                    TempStr = UserInfoPuck.getString(j);
                    TempSetF.add(TempStr);
                }
            }
            dbThEnd.InsertingIntoArchive(TempSetF.get(0),TempSetF.get(1),TempSetF.get(2),TempSetF.get(3));
            //delete
            dbThEnd.DeleteProject(StrSplitted[0]);
            dbThEnd.DeleteFromReady(StrSplitted[0]);
            Alert aaefaa = new Alert(Alert.AlertType.INFORMATION);
            aaefaa.setTitle("Информация");
            aaefaa.setContentText("Операция завершена");
            aaefaa.showAndWait();
            LoadReadyList();
        }
        else
        {
            Alert aaefa = new Alert(Alert.AlertType.INFORMATION);
            aaefa.setTitle("Ошибка");
            aaefa.setContentText("Не выбран курсовой проект");
            aaefa.showAndWait();
        }
    }
    //create report
    @FXML
    void ReportCreateButtonAction(ActionEvent event) throws SQLException {
        DatabaseHandle dbRepHadl=new DatabaseHandle();
        ResultSet RepCreSet=dbRepHadl.SelectAllFromArchive();
        ObservableList<String> TempSetrr = FXCollections.observableArrayList();
        String TempStr="";
        int columnss = RepCreSet.getMetaData().getColumnCount();
        while (RepCreSet.next()) {
            for (int j = 1; j <= columnss; j++) {
                TempStr = RepCreSet.getString(j);
                TempSetrr.add(TempStr);
            }
        }
        try(FileWriter writer = new FileWriter("report.txt", false))
        {
            // запись всей строки
            String ToWr="";
            String PartText="";
            int tempcounte=0;
            for (int i=0; i<TempSetrr.size();i++)
            {
                if (PartText.equals(""))
                {
                    PartText=TempSetrr.get(i);
                }
                else
                {
                    PartText=PartText+" "+TempSetrr.get(i);
                }
                tempcounte++;
                if (tempcounte==5)
                {
                    if (ToWr.equals(""))
                    {
                        ToWr=PartText;
                    }
                    else
                    {
                        ToWr='\n'+PartText;
                    }
                    tempcounte=0;
                    PartText="";
                    writer.write(ToWr);
                }
            }
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    //edit pass button
    @FXML
    void S2_PassButtonAction(ActionEvent event) throws SQLException {
            S2_Methods ch=new S2_Methods();
            String AccessValue=ch.getAccessofUser(GUIUserLable.getText());
            if (AccessValue.equals("0"))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Внимание!");
                alert.setContentText("У вас нет доступа");
                alert.showAndWait();
            }
            else
            {
                PassSceneOpen();
            }
    }
    void PassSceneOpen() throws SQLException {
        DefaultScenesVis();
        Manage_PasswordPanel.setVisible(true);
        DatabaseHandle dbPasHandle=new DatabaseHandle();
        ResultSet setPs=dbPasHandle.SelectAdminPass();
        String PsStr="";
        int columnss = setPs.getMetaData().getColumnCount();
        while (setPs.next()) {
            for (int j = 1; j <= columnss; j++) {
                PsStr = setPs.getString(j);
            }
        }
        Pas_PasEditField.setText(PsStr);
        Pass_UnVisLabl.setText(PsStr);
    }
    @FXML
    void Pas_PasEditButtonAction(ActionEvent event) throws SQLException {
        Alert alertcsc = new Alert(Alert.AlertType.CONFIRMATION);
        alertcsc.setTitle("Внимание!");
        alertcsc.setHeaderText("Изменение пароля регистрации администратора");
        alertcsc.setContentText("Вы действительно хотите изменит пароль администратора? ОК-Да, ОТМЕНА-Нет, Старый пароль: "+Pass_UnVisLabl.getText());

        // option != null.
        Optional<ButtonType> option = alertcsc.showAndWait();

        if (option.get() == null) {
            //null
        } else if (((Optional) option).get() == ButtonType.OK) {
            if (!Pas_PasEditField.getText().equals(""))
            {
                String NewPs=Pas_PasEditField.getText();
                DatabaseHandle hnDbHndl=new DatabaseHandle();
                hnDbHndl.UpdateAdminPass(NewPs);
                //reload
                PassSceneOpen();
            }
            else
            {
                Alert aaefa = new Alert(Alert.AlertType.INFORMATION);
                aaefa.setTitle("Внимание!");
                aaefa.setContentText("Пустое значение");
                aaefa.showAndWait();
            }
        } else if (option.get() == ButtonType.CANCEL) {

        } else {
            //null
        }
    }
    @FXML
    void initialize() throws IOException {
        DefaultScenesVis();
        CurentUserShow();
        assert Check_Scene != null : "fx:id=\"Check_Scene\" was not injected: check your FXML file 'ProgramMenu.fxml'.";
    }
}

