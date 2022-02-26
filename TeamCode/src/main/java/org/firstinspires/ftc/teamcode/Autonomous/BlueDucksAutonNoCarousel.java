package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.utils.Arm;
//import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;


//blue block side
@Autonomous(name = "BlueDucksAutonNoCarousel")
public class BlueDucksAutonNoCarousel extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        //Grab freight
//        Claw claw = new Claw(hardwareMap);
//        claw.close();
        waitForStart();

        Claw claw = new Claw(hardwareMap);
        claw.close();
        sleep(500);
        //lift
        //determine how high arm has to go to reach the top
        Arm arm = new Arm(hardwareMap);
        arm.upToPosition();
        sleep(500);

        //approach and drop into top level of the station
        MecanumDrive robot = new MecanumDrive(hardwareMap);

        // add sleep()'s if wait time is needed
        //start - turn to middle
        robot.move(0, 0, -.175);
        sleep(500);
        //one tile, middle
        robot.move(0, .5, 0);
        sleep(500);
        //turn, face hub
        claw.open();
        sleep(1000);
        claw.close();
        sleep(1000);
        arm.downToPosition();
        sleep(2000);

        robot.move(0, 0, .175);
        sleep(1000);
        //move to hub
        robot.move(0, -.5, 0);
        sleep(1000);
        //release, close, move away, lower
//        claw.open();
//        claw.close();

        sleep(1000);
        robot.move(0, -.15, 0);
        sleep(1000);

        //turn towards warehouse
        robot.move(0, 0, 0.25);
        sleep(1000);
        //move into warehouse instead of parking space
        robot.move(0, .3, 0);
        sleep(1000);
    }
}