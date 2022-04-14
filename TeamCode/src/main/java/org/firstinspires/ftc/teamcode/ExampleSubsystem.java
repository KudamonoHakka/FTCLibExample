package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.function.DoubleSupplier;

public class ExampleSubsystem extends SubsystemBase
{
    private Motor m_motor_fl;
    private Motor m_motor_fr;
    private Motor m_motor_bl;
    private Motor m_motor_br;
    private MecanumDrive mecanum;
    private Telemetry tele;


    public ExampleSubsystem(Telemetry tele, HardwareMap hMap)
    {

        // Defining telemetry as a part of this subsystem in-case we want to print some values
        this.tele = tele;

        // Define our motor hardware for the driving
        m_motor_fl = new Motor(hMap, "motorfl");
        m_motor_fr = new Motor(hMap, "motorfr");
        m_motor_bl = new Motor(hMap, "motorbl");
        m_motor_br = new Motor(hMap, "motorbr");

        // Defining a Mecanum Drive-base object; FTCLib saves us from calculating every motor movement
        mecanum = new MecanumDrive(m_motor_fl, m_motor_fr,
                m_motor_bl, m_motor_br);
    }

    public void controlMecanum(DoubleSupplier leftX, DoubleSupplier leftY, DoubleSupplier rightX)
    {
        // Give the defined drive-base object lambda values to dictate how we move
        mecanum.driveRobotCentric(-leftX.getAsDouble(), -leftY.getAsDouble(), -rightX.getAsDouble());
    }



}
