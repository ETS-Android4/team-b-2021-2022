package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    // these spin in opposite directions
    Servo clawServo_left;
    Servo clawServo_right;

    public Claw(HardwareMap hmap) {
        this.clawServo_left = hmap.servo.get(CONFIG.CLAW_L);
        this.clawServo_right = hmap.servo.get(CONFIG.CLAW_R);
    }

    public void spin(double dx) {
        clawServo_left.setPosition(dx);
        clawServo_right.setPosition(-dx);
    }

    public void close() {
        spin(-.25);
    }

    public void open() {
        spin(.5);
    }
}