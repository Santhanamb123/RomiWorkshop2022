// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.ArcadeDrive;
public class ArcadeDrive extends CommandBase {

// We put all the subsystems we are going to use here
private final Drivetrain drivetrain;

// We put all the fields we need for this command here
private final Supplier<Double> turnSpeed;
private final Supplier<Double> forwardSpeed;



  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(Supplier<Double> turnSpeed, Supplier<Double> forwardSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
  // This is how to get all the subsystems
  this.drivetrain = Drivetrain.getInstance();

  // We store our speed suppliers here
  this.turnSpeed = turnSpeed;
  this.forwardSpeed = forwardSpeed;

  // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(drivetrain); }
  // This is how to get all the subsystems
 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Start the motors at zero
    drivetrain.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Update the motors at each iteration using the suppliers
    drivetrain.arcadeDrive(turnSpeed.get(), forwardSpeed.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // End by stopping the motors again
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

