package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.utils.Arm;
//import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@Autonomous(name = "RedDucksAutonNoCarousel")
public class RedDucksAutonNoCarousel extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        waitForStart();

        //Grab freight
//        Claw claw = new Claw(hardwareMap);
//        claw.close();
        Claw claw = new Claw(hardwareMap);
        claw.open();
        //lift
        //determine how high arm has to go to reach the top
        Arm arm = new Arm(hardwareMap);
        arm.upToPosition();

        //approach and drop into top level of the station
        MecanumDrive robot = new MecanumDrive(hardwareMap);

        //start - turn to middle
        robot.move(0, 0, 0.25);
        //one tile, middle
        robot.move(.1, 0, 0);
        //turn, face hub
        robot.move(0, 0, -0.25);
        //move to hub
        robot.move(0, .1, 0);
        //release, close, move away, lower
//        claw.open();
//        claw.close();
        claw.open();
        claw.close();
        robot.move(0, -.15, 0);
        arm.downToPosition();
        //turn towards warehouse
        robot.move(0, 0, -0.25);
        //move into warehouse instead of parking space
        robot.move(0, .3, 0);
    }
}