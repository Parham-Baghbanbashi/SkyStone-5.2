import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class arcadedrive extends OpMode {

    DcMotor left;
    DcMotor right;
    double drive = -gamepad1.left_stick_y;
    double turn  =  gamepad1.right_stick_x;
    double leftPower = Range.clip(drive + turn, -1.0, 1.0) ;
    double rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
    public void init()
    {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");


    }

    public void loop()
    {
        left.setPower(leftPower);
        right.setPower(rightPower);
    }
}
