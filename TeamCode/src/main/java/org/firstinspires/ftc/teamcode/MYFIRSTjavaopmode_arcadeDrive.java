package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class MYFIRSTjavaopmode_arcadeDrive extends LinearOpMode {
    private Gyroscope gyro;
    private DcMotor motor1;
    private DigitalChannel  digitaltouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;
    private double tgtfrontpower = 0;
    public void forward(){
        motor1.setPower(tgtfrontpower);
    }
    public void servomovement(){
        if(gamepad1.y){
            servoTest.setPosition(0);
        }
        else if(gamepad1.x || gamepad1.b){
            servoTest.setPosition(90);
        }
        else if(gamepad1.a){
            servoTest.setPosition(180);
        }
    }
    public void distance(){
        telemetry.addData("Distance (cm):", sensorColorRange.getDistance(DistanceUnit.CM));
    }

    public void button_is_pressed(){
        if(digitaltouch.getState()==false){
            telemetry.addData("Button", "PRESSED");
        }
        else {
            // button is not pressed.
        telemetry.addData("Button", "NOT PRESSED");
        }
    }

    @Override
    public void runOpMode(){
        gyro = hardwareMap.get(Gyroscope.class, "gyro");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        digitaltouch = hardwareMap.get(DigitalChannel.class, "digitaltouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");

        digitaltouch.setMode(DigitalChannel.Mode.INPUT);

        telemetry.addData("Status:", "Initilazing");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Status:", "Running");
            tgtfrontpower = -this.gamepad1.left_stick_y;
            forward();
            servomovement();
            button_is_pressed();
            telemetry.addData("Motor Power:", motor1.getPower());
            telemetry.addData("Servo Position:", servoTest.getPosition());
            distance();

            telemetry.update();
        }

    }
}
