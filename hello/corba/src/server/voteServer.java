package server;

/**
 * Created by xueyuanzhang on 16/1/1.
 */
import VoteApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class voteServer {
    // A server for the Hello object





        public static void main(String args[]) {
            try{
                // create and initialize the ORB
                ORB orb = ORB.init(args, null);

                // get reference to rootpoa & activate the POAManager
                POA rootpoa =
                        (POA)orb.resolve_initial_references("RootPOA");
                rootpoa.the_POAManager().activate();

                // create servant and register it with the ORB
                voteImpl voteimpl=new voteImpl();
                orb.connect(voteimpl);
                // get object reference from the servant
                org.omg.CORBA.Object ref =
                        rootpoa.servant_to_reference(voteimpl);
                // and cast the reference to a CORBA reference
                Vote href = VoteHelper.narrow(ref);

                // get the root naming context
                // NameService invokes the transient name service
                org.omg.CORBA.Object objRef =
                        orb.resolve_initial_references("NameService");
                // Use NamingContextExt, which is part of the
                // Interoperable Naming Service (INS) specification.
                NamingContextExt ncRef =
                        NamingContextExtHelper.narrow(objRef);

                // bind the Object Reference in Naming
                String name = "Hello";
                NameComponent path[] = ncRef.to_name( name );
                ncRef.rebind(path, href);

                System.out.println
                        ("VoteServer ready and waiting ...");

                // wait for invocations from clients
                orb.run();
            }

            catch (Exception e) {
                System.err.println("ERROR: " + e);
                e.printStackTrace(System.out);
            }

            System.out.println("VoteServer Exiting ...");


    }

}
