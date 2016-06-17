package client;

/**
 * Created by xueyuanzhang on 16/1/1.
 */
import VoteApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

import java.util.List;

public class voteClient {
    static Vote voteimpl;

    public static void main(String args[]){
        try{
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext,
            // part of the Interoperable naming Service.
            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Hello";
            voteimpl=VoteHelper.narrow(ncRef.resolve_str(name));

            System.out.println
                    ("Obtained a handle on server object: "
                            + voteimpl);
            String choose=args[0];
            int chose=Integer.parseInt(choose);

            if(chose==1){

                System.out.println(voteimpl.getList());
            }
            if(chose==2){
               voteimpl.castVote(args[1]);
            }
           voteimpl.shutdown();

        }
        catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    } //end ma
}
