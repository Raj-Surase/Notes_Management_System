import java.io.*;

class SelectOptions extends NotesOption{

    void loginCheck() throws IOException{
        
        int ch = 1;


            login();
        
            if(user.equals("Student") && pass.equals("12345"))
            {
               System.out.print("\nLogin Successful!\n");
                homeOption();
            }
            else{
                System.out.print("\nLogin unsuccessful!\n");
                System.out.print("Please ckeck username and password.\n\n");

                System.out.print("1. Retry \n2. Hint \n3. Exit \n\n");
                ch = Integer.parseInt(br.readLine());

                switch(ch)
                {
                    case 1 :
                        loginCheck();
                    
                    case 2:
                        System.out.println("\nUsername = Student");
                        System.out.println("Password = 12345");
                        loginCheck();

                    case 3:
                        break;
                    
                    default:
                        System.out.println("\nPlease enter valid option!\n");
                        loginCheck();

                }
                
                
        }
        
        if(ch != 1){
            leaveMsg();
        }
    }
    void homeOption() throws IOException
    {
        int ch = 0;

        while(ch != 5)
        {
            System.out.println("\n\t----------- Welcome "+ user +" -----------");
            System.out.println("\n1. Add a note");
            System.out.println("2. Edit a note");
            System.out.println("3. Display notes");
            System.out.println("4. Delete a note");
            System.out.println("5. Exit\n");

            System.out.print("Enter your choice - ");
            ch = Integer.parseInt(br.readLine());

            switch (ch) {
                case 1:
                    noteCreate();

                    break;

                case 2:
                    noteEdit();

                    break;

                case 3:
                    noteDisplay();

                    break;

                case 4:
                    noteDelete();

                    break;

                case 5:
                    leaveMsg();

                    break;

                default:
                    System.out.println("\nPlease enter a valid choice.");
            }
        }
        
    }
}
