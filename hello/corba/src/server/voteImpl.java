package server;

/**
 * Created by xueyuanzhang on 16/1/1.
 */
import VoteApp.*;
import org.omg.CORBA.*;

import java.util.ArrayList;
import java.util.List;

class voteImpl extends VotePOA{
    private ORB orb;
    List<votePeople> vote=new ArrayList<votePeople>();
    String name1="zhu";
    String name2="zhang";
    String name3="lin";
    int ticket1=0;
    int ticket2=0;
    int ticket3=0;

    public String getList(){
     return "候选人1:"+name1+" 票数:"+ticket1+"候选人2:"+name2+" 票数:"+ticket2+"候选人3:"+name3+" 票数:"+ticket3;
    }
    public void voteCast(String username){
       if(username.compareTo(name1)==0){
           ticket1++;
       }
        if(username.compareTo(name2)==0){
            ticket2++;
        }
        if(username.compareTo(name3)==0){
            ticket3++;
        }
    }

}
