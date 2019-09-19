package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@Autonomous
public class Automumustest extends OpMode {

    DcMotor m1;
    DcMotor m2;
    DcMotor m3;
    DcMotor m4;
    Servo s1;
    Servo s2;

    double leftPower = 0.0;
    double rightPower   = 0.0 ;



    public void init() {
        m1 = hardwareMap.dcMotor.get("m1");
        m2 = hardwareMap.dcMotor.get("m2");
        m3 = hardwareMap.dcMotor.get("m3");
        m4 = hardwareMap.dcMotor.get("m4");
        s1 = hardwareMap.servo.get("s1");
        s2 = hardwareMap.servo.get("s2");
        telemetry.addData("Status:", "Initialized");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m3.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop() {
        m1.setPower(leftPower);
        m2.setPower(rightPower);
        m3.setPower(-rightPower);
        m4.setPower(-leftPower);
    }

}
