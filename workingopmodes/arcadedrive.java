
/**
----------------------------------------------------------------------------------------------------
Name: ArcadeDrive
Purpose: This program creates an arcade drive and adds servo control


Aurthor: Baghbanbashi, Parham
         email: parhambagh@gmail.com

Date: 09/19/2019
Version: 1.2.1
----------------------------------------------------------------------------------------------------
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class arcadedrive extends OpMode {

    DcMotor m1;
    DcMotor m2;
    DcMotor m3;
    DcMotor m4;
    Servo s1;
    Servo s2;

    /**
     * runs on initilaization
     */
    public void init()
    {
        /**
         * define motors
         */
        m1 = hardwareMap.dcMotor.get("m1");
        m2 = hardwareMap.dcMotor.get("m2");
        m3 = hardwareMap.dcMotor.get("m3");
        m4 = hardwareMap.dcMotor.get("m4");

        /**
         * define servos
         */
        s1 = hardwareMap.servo.get("s1");
        s2 = hardwareMap.servo.get("s2");

        /**
         * print out status
         */
        telemetry.addData("Status:", "Initialized");

        /**
         * set left side motors to reverse
         */
        m1.setDirection(DcMotor.Direction.REVERSE);
        m3.setDirection(DcMotor.Direction.REVERSE);


    }


    /**
     * runs repetedly after person hits play
     */
    public void loop()
    {
        // print out status
        telemetry.addData("Status:", "Running");

        /**
         * print out right and left motor power
         */
        telemetry.addData("Rightmoter", m2.getPower());
        telemetry.addData("Leftmotor", m1.getPower());

        //print out servo positons
        telemetry.addData("servo 1", s1.getPosition());
        telemetry.addData("servo2", s2.getPosition());

        /**
         * define the gamepad inputs
         */
        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;

        // define left and right powers
        double leftPower = Range.clip(drive + turn, -1.0, 1.0) ;
        double rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

        // print out gamepad status
        telemetry.addData("Y", drive);
        telemetry.addData("X", turn);

        /**
         * set power of motors to the gamepad imputs
         */
        m1.setPower(leftPower);
        m2.setPower(rightPower);
        m3.setPower(-rightPower);
        m4.setPower(-leftPower);

        /**
        * various difrent servo set position statment
         */

        /**
         * set posion of servos to 0.5 if button y is pressed
         */

        if(gamepad1.y == true)
        {
            s1.setPosition(1.0);
            s2.setPosition(-0.5);
        }

        /** set servos positon to 0.5 if button a is presed
         */
        if(gamepad1.a){
            s1.setPosition(-0.5);
            s2.setPosition(1.0);
        }


    }
}
