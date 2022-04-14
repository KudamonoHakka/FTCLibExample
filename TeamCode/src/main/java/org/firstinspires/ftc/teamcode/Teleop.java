package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Sample TeleOp")
public class Teleop extends CommandOpMode
{

    private ExampleSubsystem m_exampleSubsystem;
    private GamepadEx gamepad_1;

    @Override
    public void initialize()
    {
        m_exampleSubsystem = new ExampleSubsystem(telemetry, hardwareMap);
        gamepad_1 = new GamepadEx(gamepad1);
        ExampleCommand example_command = new ExampleCommand(m_exampleSubsystem, gamepad_1::getLeftX,gamepad_1::getLeftY, gamepad_1::getRightX);


        register(m_exampleSubsystem);
        CommandScheduler.getInstance().setDefaultCommand(m_exampleSubsystem, example_command);

    }

    @Override
    public void run()
    {   
        //m_motor_car.set(0.5);
        CommandScheduler.getInstance().run();
    }
}
