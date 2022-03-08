package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp

public class TestController extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor backleft = null;
    private DcMotor backright = null;
    private DcMotor frontleft = null;
    private DcMotor frontright = null;

    @Override
    public void init() {
        telemetry.addData( "Status", "Initialized");

        //Initialize the hardware variables

        backleft = hardwareMap.get(DcMotor.class, "backleft");
        backright = hardwareMap.get(DcMotor.class, "backright");
        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        frontright = hardwareMap.get(DcMotor.class, "frontright");

        backleft.setDirection(DcMotor.Direction.FORWARD);
        backright.setDirection(DcMotor.Direction.REVERSE);
        frontleft.setDirection(DcMotor.Direction.FORWARD);
        frontright.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData( "Status", "Initialized");

    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        runtime.reset();
    }


    public void turn() {
        double leftPower;
        double rightPower;

        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        leftPower = Range.clip(drive + turn, -1.0, 1.0);
        rightPower = Range.clip(drive - turn, -1.0, 1.0);

        backleft.setPower(leftPower);
        backright.setPower(rightPower);

        frontleft.setPower(leftPower);
        frontright.setPower(rightPower);


        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);

    }

    @Override
    public void loop() {
        turn();
    }

    @Override
    public void stop() {

    }
}
