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
        telemetry.addData(caption: "Status", value: "Initialized");

        //Initialize the hardware variables

        backleft = hardwareMap.get(DcMotor.class, deviceName: "backleft");
        backright = hardwareMap.get(DcMotor.class, deviceName: "backright");
        frontleft = hardwareMap.get(DcMotor.class, deviceName: "frontleft");
        frontright = hardwareMap.get(DcMotor.class, deviceName: "frontright");

        backleft.setDirection(DcMotor.Direction.FORWARD);
        backright.setDirection(DcMotor.Direction.REVERSE);
        frontleft.setDirection(DcMotor.Direction.FORWARD);
        frontright.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData(caption: "Status", value: "Initialized");

    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        turn();
    }

    @Override
    public void stop() {

    }



    public void turn() {
        double leftPower;
        double rightPower;

        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        leftPower = Range.clip(number: drive + turn, min: -1.0, max: 1.0);
        rightPower = Range.clip(number: drive - turn, min: -1.0, max: 1.0);

        backleft.setPower(leftPower);
        backright.setPower(rightPower);

        frontleft.setPower(leftPower);
        frontright.setPower(rightPower);


        telemetry.addData(caption: "Status", value: "Run Time: " + runtime.toString());
        telemetry.addData(caption: "Motors", value: "left (%.2f), right (%.2f)", leftPower, rightPower);

    }
}
