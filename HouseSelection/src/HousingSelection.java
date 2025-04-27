import java.util.Scanner;

public class HousingSelection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalPoints = 0;

        System.out.println("Hello and welcome to the house selection app. We will be asking a few questions to help determine your eligibility for campus housing.\n" +
                "Hit enter to begin");
        input.nextLine(); // Consume the enter key press

        // Academic year
        System.out.println("What is your current academic year? (freshman/sophomore/junior/senior/super senior)");
        String year = input.nextLine().toLowerCase();
        switch (year) {
            case "freshman":
                System.out.println("You are a first year student, 4 points");
                totalPoints += 4;
                break;
            case "sophomore":
                System.out.println("You are a second year student, 4 points");
                totalPoints += 4;
                break;
            case "junior":
                System.out.println("You are a third year student, 4 points");
                totalPoints += 4;
                break;
            case "senior":
                System.out.println("You are a fourth year student, 4 points");
                totalPoints += 4;
                break;
            case "super senior":
                System.out.println("You are a fifth year student or above, 0 points");
                break;
            default:
                System.out.println("Invalid year, 0 points");
        }

        // Travel time
        System.out.println("Approximately, how long does it take for you to get to campus in number of hours?");
        int hours = input.nextInt();
        input.nextLine(); // Consume the newline
        if (hours <= 2) {
            System.out.println("Reasonable travel time, 2 points");
            totalPoints += 2;
        } else {
            System.out.println("Unreasonable travel time, 0 points");
        }

        // Student caregiver
        System.out.println("Are you a student caregiver? (yes/no)");
        String isCaregiver = input.nextLine().toLowerCase();
        if (isCaregiver.equals("yes")) { // checks if this is what the user inputted
            System.out.println("You are a student caregiver, 5 points");
            totalPoints += 5;
        } else {
            System.out.println("You are not a student caregiver, 0 points");
        }

        // Suspension status
        System.out.println("Are you in the status of near suspension? (yes/no)");
        String status = input.nextLine().toLowerCase();
        if (status.equals("yes")) {
            System.out.println("You are in the status of near suspension, -2 points");
            totalPoints -= 2;
        } else {
            System.out.println("You are not in the status of near suspension, 0 points");
        }

        // Student status
        System.out.println("Are you a full-time or part-time student? (full-time/part-time)");
        String timeS = input.nextLine().toLowerCase();
        if (timeS.equals("full-time")) {
            System.out.println("You are a full-time student, 0 points");
        } else if (timeS.equals("part-time")) {
            System.out.println("You are a part-time student, 0 points");
        } else {
            System.out.println("Invalid input. Choices: full-time/part-time, 0 points");
            timeS = "unknown"; // Set to unknown to avoid errors in work question
        }

        // Work location
        System.out.println("Do you work on or off campus? (on campus/off campus/don't work)");
        String workOn = input.nextLine().toLowerCase();
        if (workOn.equals("on campus") && timeS.equals("full-time")) {
            System.out.println("You are a full-time student working on campus, 3 points");
            totalPoints += 3;
        } else if (workOn.equals("on campus") && timeS.equals("part-time")) {
            System.out.println("You are a part-time student working on campus, 2 points");
            totalPoints += 2;
        } else if (workOn.equals("on campus")) {
            System.out.println("You work on campus, 1 point");
            totalPoints += 1;
        } else if (workOn.equals("off campus")) {
            System.out.println("You work off campus, 0 points");
        } else {
            System.out.println("You don't work, 0 points");
        }

        // Abusive household
        System.out.println("Are you in a documented abusive household? (yes/no)");
        String abusive = input.nextLine().toLowerCase();
        if (abusive.equals("yes")) {
            System.out.println("You are in a documented abusive household, 5 points");
            totalPoints += 5;
        } else if (abusive.equals("no")) {
            System.out.println("You are not in a documented abusive household, 0 points");
        } else {
            System.out.println("Invalid input. Choices: yes/no, 0 points");
        }

        // Reliable workstation
        System.out.println("Do you have a reliable workstation with internet access? (yes/no)");
        String reliable = input.nextLine().toLowerCase();
        if (reliable.equals("yes")) {
            System.out.println("You have a reliable workstation with internet access, 0 points");
        } else if (reliable.equals("no")) {
            System.out.println("You do not have a reliable workstation, 2 points");
            totalPoints += 2;
        } else {
            System.out.println("Invalid input. Choices: yes/no, 0 points");
        }

        // Medical condition
        System.out.println("Do you have a medical condition hindering your commute? (yes/no)");
        String medicalCondition = input.nextLine().toLowerCase();
        if (medicalCondition.equals("yes")) {
            System.out.println("You have a medical condition hindering your commute, 4 points");
            totalPoints += 4;
        } else if (medicalCondition.equals("no")) {
            System.out.println("You do not have a medical condition hindering your commute, 0 points");
        } else {
            System.out.println("Invalid input. Choices: yes/no, 0 points");
        }

        // Display final score
        System.out.println("\nThank you for your time. Your determined score for housing is: " + totalPoints + " points");

        // Housing eligibility recommendation based on score
        if (totalPoints >= 10) {
            System.out.println("Based on your score, you have a high priority for campus housing.");
        } else if (totalPoints >= 5) {
            System.out.println("Based on your score, you have a moderate priority for campus housing.");
        } else {
            System.out.println("Based on your score, you have a low priority for campus housing.");
        }

        input.close();
    }
}