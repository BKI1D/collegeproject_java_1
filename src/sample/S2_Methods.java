package sample;

import javafx.scene.control.Alert;

import java.rmi.server.ExportException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class S2_Methods {
    //variables

    //load group and names proc-s
    //load User Info
    ResultSet LoadUserInformation1(String S2_GroupSearch)
    {
        DatabaseHandle dbHandler= new DatabaseHandle();
        ResultSet UsRez1 = dbHandler.getUserInfoList(S2_GroupSearch,1);
         return UsRez1;
    }
    ResultSet LoadUserInformation2(String S2_GroupSearch)
    {
        DatabaseHandle dbHandler= new DatabaseHandle();
        ResultSet UsRez2 = dbHandler.getUserInfoList(S2_GroupSearch,2);
        return UsRez2;
    }
    //load group
    ResultSet LoadGroupToList()
    {
        DatabaseHandle dbHandler= new DatabaseHandle();
        ResultSet Grez = dbHandler.getGroupforList();
        return Grez;
    }
    //load info about user
    ResultSet LoadInfoAboutUser(String R_Group, String R_NameString)
    {
        String[] NamesSplitted = R_NameString.split(" ");
        DatabaseHandle dbHandler= new DatabaseHandle();
        ResultSet UserPackSet = dbHandler.getUserInfoPack(R_Group,NamesSplitted[0],NamesSplitted[1]);
        return UserPackSet;
    }
    //Get current date
    Date GetCurrentDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Date localDate =java.sql.Date.valueOf(LocalDate.now());
        return localDate;
    }
    //Convert to Date
    Date ConvertDateFromString(String DatetoConvert)
    {
        SimpleDateFormat dtf=new SimpleDateFormat("dd-MM-yyyy");
        Date FxConvertedDate= null;
        try {
            FxConvertedDate = dtf.parse(DatetoConvert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return FxConvertedDate;
    }
    //GetCurrentUser from DB
    String GetCurrentUserfromROM() {
        //String to return
        String DataStringRom="";
        try
        {
            DatabaseHandle dbHadle=new DatabaseHandle();
            ResultSet CurSet=dbHadle.GetCurentRomValue();
            int columns = CurSet.getMetaData().getColumnCount();

            while (CurSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    DataStringRom = CurSet.getString(i);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  DataStringRom;
    }
    //get access code for user
    String getAccessofUser(String UsToSearch)
    {
        String AccCoderet="";
        try
        {
            DatabaseHandle dbHandle=new DatabaseHandle();
            ResultSet CodeSet= dbHandle.getUserActionCode(UsToSearch);
            int columns = CodeSet.getMetaData().getColumnCount();

            while (CodeSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    AccCoderet = CodeSet.getString(i);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return AccCoderet;
    }
    //check for numeric string
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    //check for isDate inputted
    public boolean isDate(String strr)
    {
        boolean returnbool=false;
        try
        {
            String[] DateInpSplit = strr.split("-");
            int incount=0;
            for (int i=0; i<DateInpSplit.length;i++)
            {
                incount++;
            }
            if (DateInpSplit[0].length() == 2 && DateInpSplit[1].length()==2 && DateInpSplit[2].length()==4)
            {
                if (incount==3)
                {
                    //check for correct mm dd yyyy
                    if(Integer.parseInt(DateInpSplit[0])<32&& Integer.parseInt(DateInpSplit[1])!=00)
                    {
                        if (Integer.parseInt(DateInpSplit[1])<13 && Integer.parseInt(DateInpSplit[1])!=00)
                        {
                            if (Integer.parseInt(DateInpSplit[2])!=0000)
                            {
                                returnbool=true;
                            }
                            else
                            {
                                returnbool=false;
                            }
                        }
                        else
                        {
                            returnbool=false;
                        }
                    }
                    else
                    {
                        returnbool=false;
                    }
                }
                else
                {
                    returnbool=false;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return returnbool;
    }
    //insert new ready user
    void InsertingReady(String IDtoIns,String NameChk,String SecNameChk,String ThemeChk)
    {
        DatabaseHandle dbHdl=new DatabaseHandle();
        boolean GetInfo=dbHdl.CheckReadyTable(IDtoIns,NameChk,SecNameChk,ThemeChk);
        if (GetInfo==false)
        {
            Alert alere = new Alert(Alert.AlertType.INFORMATION);
            alere.setTitle("Внимание!");
            alere.setContentText("Информация уже внесена");
            alere.showAndWait();
        }
        else
        {
            String IdToInserting="";

            ResultSet GetSetOfId=dbHdl.GetIdofProjectUser(NameChk,SecNameChk,ThemeChk);

            try {
                int clmns=GetSetOfId.getMetaData().getColumnCount();
                while (GetSetOfId.next()) {
                    for (int i = 1; i <= clmns; i++) {
                        IdToInserting = (GetSetOfId.getString(i));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            dbHdl.InsertingReadyProjects(IdToInserting);

            Alert alereq = new Alert(Alert.AlertType.INFORMATION);
            alereq.setTitle("Результат операции");
            alereq.setContentText("Данные внесены");
            alereq.showAndWait();
        }
    }
}
