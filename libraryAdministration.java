import java.util.Scanner;
import src.People;

class libraryAdministration
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        boolean open=true;
        String option,pause,firstname,lastname,temp;
        while(open)
        {
            System.out.println("########################");
            System.out.println("#Library Administration#");
            System.out.println("########################\n");
            System.out.println("1->Add people");
            System.out.println("2->Show people");
            System.out.println("3->Remove people from index");
            System.out.println("4->Find people from index");
            System.out.println("5->Exit\n");
            System.out.print("Option: ");
            option=input.nextLine();
            switch(option)
            {
                case "1":
                    System.out.print("\033\143");
                    System.out.print("First Name: ");
                    firstname=input.nextLine();
                    System.out.print("Last Name: ");
                    lastname=input.nextLine();
                    System.out.print("Book List: ");
                    temp=input.nextLine();
                    People.add(firstname,lastname,temp);
                    break;
                case "2":
                    System.out.print("\033\143");
                    System.out.println("Peopel's Database:\n");
                    People.show();
                    pause=input.nextLine();
                    break;
                case "3":
                    System.out.print("\033\143");
                    System.out.print("Number of index: ");
                    temp=input.nextLine();
                    try
                    {
                        People.remove(Integer.valueOf(temp));
                    }
                    catch(Exception e)
                    {
                        System.out.print("\nError! Not numerical value!");
                        pause=input.nextLine();
                    }
                    break;
                case "4":
                    System.out.print("\033\143");
                    System.out.print("Number of index: ");
                    temp=input.nextLine();
                    try
                    {
                        People.show(Integer.valueOf(temp));
                        pause=input.nextLine();
                    }
                    catch(Exception e)
                    {
                        System.out.print("\nError! Not numerical value!");
                        pause=input.nextLine();
                    }
                    break;
                case "5":
                    open=false;
                    break;
                default:
                    break;
            }
            System.out.print("\033\143");
        }
    }
}