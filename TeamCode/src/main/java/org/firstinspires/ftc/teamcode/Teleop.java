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
        // Create instance of our ExampleSubsystem which drives the robot; telemetry is extra incase we want to print values to console
        m_exampleSubsystem = new ExampleSubsystem(telemetry, hardwareMap);

        // Define game-pad object
        gamepad_1 = new GamepadEx(gamepad1);

        // Defining a command for driving robot, using those cool lambdas we learned about earlier this year
        ExampleCommand example_command = new ExampleCommand(m_exampleSubsystem, gamepad_1::getLeftX,gamepad_1::getLeftY, gamepad_1::getRightX);

        // Registering the subsystem for the scheduler and making a default command for the subsystem
        register(m_exampleSubsystem);
        CommandScheduler.getInstance().setDefaultCommand(m_exampleSubsystem, example_command);

    }

    @Override
    public void run()
    {
        // Make sure the Command Scheduler is running so that our defined Commands and Subsystems run
        CommandScheduler.getInstance().run();
    }
}
