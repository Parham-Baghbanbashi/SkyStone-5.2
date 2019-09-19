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
    int nums =1;
    public void init()
    {
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

    public void loop()
    {
        telemetry.addData("Status:", "Running");
        telemetry.addData("Rightmoter", m2.getPower());
        telemetry.addData("Leftmotor", m1.getPower());
        telemetry.addData("servo 1", s1.getPosition());
        telemetry.addData("servo2", s2.getPosition());
        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.left_stick_x;
        double leftPower = Range.clip(drive + turn, -1.0, 1.0) ;
        double rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
        telemetry.addData("Y", drive);
        telemetry.addData("x", turn);
        m1.setPower(leftPower);
        m2.setPower(rightPower);
        m3.setPower(-rightPower);
        m4.setPower(-leftPower);
        if(gamepad1.y == true)
        {
            s1.setPosition(0);
        }
        if(gamepad1.a){
            s1.setPosition(180);
        }

        if(gamepad1.b){
            s2.setPosition(0);
        }
        if(gamepad1.x){
            s2.setPosition(180);
        }

    }
}
