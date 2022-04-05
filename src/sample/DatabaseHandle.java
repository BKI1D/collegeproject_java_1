package sample;

import java.sql.*;

//Class to connect to Db
public class DatabaseHandle extends Configs {
Connection dbConnection;

public Connection getDbConnection()
throws ClassNotFoundException, SQLException
{
    String connectionString = "jdbc:mysql://127.0.0.1:3306/kurs?useLegacyDatetimeCode=false&serverTimezone=UTC";
 // load and register JDBC driver for MySQL
    Class.forName("com.mysql.cj.jdbc.Driver");
 dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
 return  dbConnection;
}
//For getUserValues
public ResultSet getUser(User user)
{
   ResultSet resSet = null;
   String select = "SELECT * FROM " + Const.USER_Table
           + " WHERE " + Const.USER_Login + "=? AND " + Const.USER_Password + "=?";
 try {
  PreparedStatement prSt = getDbConnection().prepareStatement(select);
  prSt.setString(1,user.getLogin());
  prSt.setString(2,user.getPassword());
  resSet=prSt.executeQuery();
 } catch (SQLException | ClassNotFoundException e) {
  e.printStackTrace();
 }

   return resSet;
}
//for getGroup(List)
public ResultSet getGroupforList()
{
    ResultSet resGSet=null;
    String selectGroup="SELECT"+ " DISTINCT " + Const.PROJECT_Group + " " + "FROM " + Const.PROJECT_Table;
    try
    {
        PreparedStatement prGSt=getDbConnection().prepareStatement(selectGroup);
        resGSet=prGSt.executeQuery();
    }
    catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return resGSet;
}
//for getUser(List)
    public ResultSet getUserInfoList(String gU_GroupSearch, int OperationNumber)
    {
        ResultSet resUSet = null;
        //1 to get Set with FirstName and 2 to Second
        if (OperationNumber==1) {
            String selectUserForList = "SELECT " + Const.PROJECT_Firstname + " FROM "
                    + Const.PROJECT_Table+ " WHERE " +Const.PROJECT_Group + "=?";;
            try {
                PreparedStatement prGSt = getDbConnection().prepareStatement(selectUserForList);
                prGSt.setString(1,gU_GroupSearch);
                resUSet = prGSt.executeQuery();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else
        {
            String selectUserForList = "SELECT " + Const.PROJECT_Secondname + " FROM "
                    + Const.PROJECT_Table + " WHERE " +Const.PROJECT_Group + "=?";
            try {
                PreparedStatement prGSt = getDbConnection().prepareStatement(selectUserForList);
                prGSt.setString(1,gU_GroupSearch);
                resUSet = prGSt.executeQuery();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return  resUSet;
    }
    //for getUserInfoPack
    public ResultSet getUserInfoPack(String S_GroupNum, String S_Name, String S_SName)
    {
        ResultSet resUPSet = null;
        String SelectInfoPack = "SELECT * FROM " + Const.PROJECT_Table + " WHERE " + Const.PROJECT_Group + "=? AND "+ Const.PROJECT_Firstname + "=? AND " + Const.PROJECT_Secondname + "=?";
        try {
            PreparedStatement prUpSt = getDbConnection().prepareStatement(SelectInfoPack);
            prUpSt.setString(1,S_GroupNum);
            prUpSt.setString(2,S_Name);
            prUpSt.setString(3,S_SName);
            resUPSet = prUpSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  resUPSet;
    }
    //to get user access code
    public ResultSet getUserActionCode(String UserLogin)
    {
        ResultSet resCodeSet = null;
        String select = "SELECT " + Const.USER_Access + " FROM " + Const.USER_Table
                + " WHERE " + Const.USER_Login + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,UserLogin);
            resCodeSet=prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resCodeSet;
    }
//For SignUP
  public void signUpUser(User user)
 {
     //insert query
     String insert = "INSERT INTO " + Const.USER_Table + "(" + Const.USER_Login + "," + Const.USER_Password + "," + Const.USER_Email + "," + Const.USER_Access + ")" + "VALUES(?,?,?,?)";

  try {
   PreparedStatement prSt = getDbConnection().prepareStatement(insert);
   prSt.setString(1,user.getLogin());
   prSt.setString(2,user.getPassword());
   prSt.setString(3,user.getEmail());
   prSt.setInt(4,user.getAccessCode());
   prSt.executeUpdate();
  } catch (SQLException e) {
   e.printStackTrace();
  } catch (ClassNotFoundException e) {
   e.printStackTrace();
  }
 }
 //update ROM table
    public void UpdateROMtable(String Log_toRom)
    {
        String updaterROM="UPDATE " + Const.ROM_Table +
                " set "+ Const.ROM_CurUser + "=?" +
                " WHERE " + Const.ROM_idROM + "=1";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(updaterROM);
            prSt.setString(1,Log_toRom);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //get value from ROM table
    public ResultSet GetCurentRomValue()
    {
        ResultSet resCurSet = null;
        String RowSelect = "SELECT * FROM "+Const.ROM_Table;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(RowSelect);
            resCurSet=prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resCurSet;
    }
    //insert new project
    public void InsertProject(ProjectStudent stud)
    {
        String InsertLine="INSERT INTO " + Const.PROJECT_Table+"(" + Const.PROJECT_Firstname + "," + Const.PROJECT_Secondname +","+Const.PROJECT_Theme+","+Const.PROJECT_Group+","
                + Const.PROJECT_Dedline + ","+Const.PROJECT_ConceptEnd+","+Const.PROJECT_ConceptRec+","+Const.PROJECT_ConMark+","+Const.PROJECT_AppBaseEnd+","+Const.PROJECT_AppBaseRec
                + "," + Const.PROJECT_AppBaseMark+","+Const.PROJECT_AppAddEnd+","+Const.PROJECT_AppAddRec+","+Const.PROJECT_AppAddMark+","
                + Const.PROJECT_DocDateEnd+","+Const.PROJECT_DocDateRec+","+Const.PROJECT_DocMark+","+ Const.PROJECT_Passed+","+Const.PROJECT_TotMark+ ")"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(InsertLine);
            prSt.setString(1,stud.getpFName());
            prSt.setString(2,stud.getpSName());
            prSt.setString(3,stud.getpTheme());
            prSt.setString(4,stud.getpGroupNumber());
            prSt.setString(5,stud.getpDedLine());
            prSt.setString(6,stud.getpConceptDedline());
            prSt.setString(7,stud.getpConceptDedlineRec());
            prSt.setString(8,stud.getpConceptMark());
            prSt.setString(9,stud.getpBaseFxDedLine());
            prSt.setString(10,stud.getpBaseFxDedLineRec());
            prSt.setString(11,stud.getpBaseFxMark());
            prSt.setString(12,stud.getpAddFxDedline());
            prSt.setString(13,stud.getpAddFxDedlineRec());
            prSt.setString(14,stud.getpAddFxMark());
            prSt.setString(15,stud.getpDocDedline());
            prSt.setString(16,stud.getpDocDedlineRec());
            prSt.setString(17,stud.getpDocMark());
            prSt.setString(18,stud.getpPassedSect());
            prSt.setString(19,stud.getpTotalMark());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //check ready table
    ResultSet GetIdofProjectUser(String CName,String CSName,String Theme)
    {
        ResultSet setToCompare=null;
        String SelectSomeInfo="SELECT " + Const.PROJECT_IdProject + " FROM " + Const.PROJECT_Table + " WHERE "+Const.PROJECT_Firstname
                + "=?" + " AND " + Const.PROJECT_Secondname+"=?"+" AND " + Const.PROJECT_Theme + "=?";
        try {
            PreparedStatement prSta = getDbConnection().prepareStatement(SelectSomeInfo);
            prSta.setString(1,CName);
            prSta.setString(2,CSName);
            prSta.setString(3,Theme);
            setToCompare=prSta.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return setToCompare;
    }
    public boolean CheckReadyTable(String ComparID,String CName,String CSName,String Theme)
    {
        boolean BoBooBul=false;
        String TempCompId="";
        ResultSet setToComparre=GetIdofProjectUser(CName,CSName,Theme);
        try {
            int ccolumns=setToComparre.getMetaData().getColumnCount();
            while (setToComparre.next()) {
                for (int i = 1; i <= ccolumns; i++) {
                    TempCompId = (setToComparre.getString(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet setToCheck=null;
        String SelectReady="SELECT "+Const.READY_idRow +" FROM " + Const.READY_Table + " WHERE " + Const.READY_ReadyId + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(SelectReady);
            prSt.setString(1,TempCompId);
            setToCheck=prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int columns = 0;
        String TempString="";
        try {
            columns = setToCheck.getMetaData().getColumnCount();
            while (setToCheck.next()) {
                for (int i = 1; i <= columns; i++) {
                    TempString = setToCheck.getString(i);
                }
            }
            if (TempString!="")
            {
                BoBooBul=false;
            }
            else
            {
                BoBooBul=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BoBooBul;
    }
    //insert id to table with ready to complete
    public void InsertingReadyProjects(String ReadyID)
    {
        String InsertRow="INSERT INTO " + Const.READY_Table + "(" + Const.READY_ReadyId + ")" + "VALUES(?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(InsertRow);
            prSt.setString(1,ReadyID);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //insert into archive
    public void InsertingIntoArchive(String iFName, String iSName, String iTheme, String iMark)
    {
        String InsertRow="INSERT INTO "+Const.ARCHIVE_Table+"("+Const.ARCHIVE_FName+","+Const.ARCHIVE_SecName+","+Const.ARCHIVE_Theme+","+Const.ARCHIVE_Mark+")"
                +"VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(InsertRow);
            prSt.setString(1,iFName);
            prSt.setString(2,iSName);
            prSt.setString(3,iTheme);
            prSt.setString(4,iMark);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //delete from projects
    public void DeleteProject(String CheckID)
    {
        String DeleteRow="DELETE FROM "+Const.PROJECT_Table+" WHERE "+Const.PROJECT_IdProject+"=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(DeleteRow);
            prSt.setString(1,CheckID);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //update project table
    public void UpdateProjectTable(ProjectStudent prStud,String IdPrjct)
    {
        String UpdateLine="UPDATE "+Const.PROJECT_Table+" set "+Const.PROJECT_Firstname+ "=?"+","
            + Const.PROJECT_Secondname+"=?"+","+Const.PROJECT_Theme+"=?"+","+
                Const.PROJECT_Group+"=?"+","+Const.PROJECT_Dedline+"=?"+","+
                Const.PROJECT_ConceptEnd+"=?"+","+Const.PROJECT_ConceptRec+"=?"+","+
                Const.PROJECT_ConMark+"=?"+","+Const.PROJECT_AppBaseEnd+"=?"+","+
                Const.PROJECT_AppBaseRec+"=?"+","+Const.PROJECT_AppBaseMark+"=?"+","+
                Const.PROJECT_AppAddEnd+"=?"+","+Const.PROJECT_AppAddRec+"=?"+","+Const.PROJECT_AppAddMark+"=?"+","+
                        Const.PROJECT_DocDateEnd+"=?"+","+Const.PROJECT_DocDateRec+"=?"+","+
                        Const.PROJECT_DocMark+"=?"+","+Const.PROJECT_Passed+"=?"+","+Const.PROJECT_TotMark+"=?"+
                        " WHERE "+Const.PROJECT_IdProject+"=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(UpdateLine);
            prSt.setString(1,prStud.getpFName());
            prSt.setString(2,prStud.getpSName());
            prSt.setString(3,prStud.getpTheme());
            prSt.setString(4,prStud.getpGroupNumber());
            prSt.setString(5,prStud.getpDedLine());
            prSt.setString(6,prStud.getpConceptDedline());
            prSt.setString(7,prStud.getpConceptDedlineRec());
            prSt.setString(8,prStud.getpConceptMark());
            prSt.setString(9,prStud.getpBaseFxDedLine());
            prSt.setString(10,prStud.getpBaseFxDedLineRec());
            prSt.setString(11,prStud.getpBaseFxMark());
            prSt.setString(12,prStud.getpAddFxDedline());
            prSt.setString(13,prStud.getpAddFxDedlineRec());
            prSt.setString(14,prStud.getpAddFxMark());
            prSt.setString(15,prStud.getpDocDedline());
            prSt.setString(16,prStud.getpDocDedlineRec());
            prSt.setString(17,prStud.getpDocMark());
            prSt.setString(18,prStud.getpPassedSect());
            prSt.setString(19,prStud.getpTotalMark());
            prSt.setString(20,IdPrjct);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //select ready users ID
    ResultSet SelectIDSet()
    {
        ResultSet settoReturn=null;
        String SelectIDRow="SELECT "+Const.READY_ReadyId+ " FROM "+Const.READY_Table;

        try {
            PreparedStatement prSta = getDbConnection().prepareStatement(SelectIDRow);
            settoReturn=prSta.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return settoReturn;
    }
    //select user ifo by ID
    //1
    ResultSet SelectUserByID(String SearchID)
    {
        ResultSet setOfUserInfo=null;
        String SelectingRow="SELECT "+Const.PROJECT_Firstname+","+Const.PROJECT_Secondname+","+Const.PROJECT_Group+","+Const.PROJECT_Theme+" FROM " +Const.PROJECT_Table+" WHERE "+Const.PROJECT_IdProject+"=?";

        try {
            PreparedStatement prSta = getDbConnection().prepareStatement(SelectingRow);
            prSta.setString(1,SearchID);
            setOfUserInfo=prSta.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return setOfUserInfo;
    }
    //2
    ResultSet SelectUserByIDforInsert(String SearchID)
    {
        ResultSet setOfUserInfo=null;
        String SelectingRow="SELECT "+Const.PROJECT_Firstname+","+Const.PROJECT_Secondname+","+Const.PROJECT_Theme+","+Const.PROJECT_TotMark+" FROM " +Const.PROJECT_Table+" WHERE "+Const.PROJECT_IdProject+"=?";

        try {
            PreparedStatement prSta = getDbConnection().prepareStatement(SelectingRow);
            prSta.setString(1,SearchID);
            setOfUserInfo=prSta.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return setOfUserInfo;
    }
    //Delete from readylist
    public void DeleteFromReady(String IdtoDel)
    {
        String DeleteRow="DELETE FROM "+Const.READY_Table+" WHERE "+Const.READY_ReadyId+"=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(DeleteRow);
            prSt.setString(1,IdtoDel);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //Select all from archive
    ResultSet SelectAllFromArchive()
    {
        ResultSet ArchSet=null;
        String Selecting="SELECT * FROM "+Const.ARCHIVE_Table;

        try {
            PreparedStatement prSta = getDbConnection().prepareStatement(Selecting);
            ArchSet=prSta.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ArchSet;
    }
    //Select pass from passtable
    ResultSet SelectAdminPass()
    {
        ResultSet PassSet=null;
        String SelectPass="SELECT " +Const.ADMIN_AdminPass + " FROM " + Const.ADMIN_Table + " WHERE idAdminPass=1";

        try {
            PreparedStatement prSta = getDbConnection().prepareStatement(SelectPass);
            PassSet=prSta.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return PassSet;
    }
    //update admin pass
    public void UpdateAdminPass(String NewPass)
    {
        String UpdatePass="UPDATE "+Const.ADMIN_Table+" SET "+Const.ADMIN_AdminPass+"=?"+" WHERE idAdminPass=1";

        try {
            PreparedStatement prSta = getDbConnection().prepareStatement(UpdatePass);
            prSta.setString(1,NewPass);
            prSta.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
