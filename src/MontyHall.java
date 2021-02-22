import java.util.Random;

public class MontyHall {
    private static int wins, losses;
    private static final int[] doors = new int[3];

    public static void main(String[] args) {

        int reps = 1000; //how often a door gets chosen
        Random random = new Random();
        System.out.printf("Repetitions: %d",reps);
        System.out.println("-".repeat(50));

        doors[random.nextInt(doors.length)] = 1; //1 represents a win, the win is set to a random position

        for (int i =0; i<doors.length;i++){
            //The rest of the doors is set to a loss
            if(doors[i]!=1){
                doors[i] = 0;
            }
        }

        for (int i =0;i<reps;i++){
            noSwitch(random.nextInt(doors.length)); //call the noSwitch method with a random chosen position
        }

        System.out.println("No switch");
        printResult(); //print the results: wins, losses %wins

        for(int i = 0; i<reps; i++){
            switchPlace(random.nextInt(doors.length)); //now switch doors
        }

        System.out.println("Switch");
        printResult();

    }

    static void noSwitch(int i){
        //we stay at the chosen door. 1 represents a win, 0 a loss
        if(doors[i]==1){
            wins++;
        }else{
            losses++;
        }
    }

    static void switchPlace(int index){
        int openedDoor = 0;
        for(int i = 0;i<doors.length;i++ ){
            if(i!=index&&doors[i]!=1){
                //a door that isn´t the chosen door or the winning door is opened(eliminated)
                openedDoor = i;
                break;
            }
        }
        int switchDoor = 0;
        for (int i = 0; i<doors.length;i++){
            if(i!=index&&i!=openedDoor){
                //the door we didn't choose and isn't opened get chosen now
                switchDoor = i;
            }
        }

        if(doors[switchDoor]==1){
            wins++;
        }else{
            losses++;
        }
    }


    static void printResult(){
        System.out.println("-".repeat(50));
        System.out.printf("Wins: %d%nLosses: %d%n",wins,losses);
        System.out.printf("Wins per attempt: %f%n",(wins*1.0)/(losses+wins));
        System.out.println("-".repeat(50));
        wins = 0;
        losses = 0;
    }


}
