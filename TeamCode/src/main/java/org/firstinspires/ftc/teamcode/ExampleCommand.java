package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class ExampleCommand extends CommandBase
{
    private DoubleSupplier m_leftX;
    private DoubleSupplier m_leftY;
    private DoubleSupplier m_rightY;
    private ExampleSubsystem m_subsystem;

    public ExampleCommand(ExampleSubsystem subsystem, DoubleSupplier leftX, DoubleSupplier leftY, DoubleSupplier rightY)
    {
        m_subsystem = subsystem;
        m_leftX = leftX;
        m_leftY = leftY;
        m_rightY = rightY;

        addRequirements(m_subsystem);
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {
        m_subsystem.controlMecanum(m_leftX, m_leftY, m_rightY);
    }
}
