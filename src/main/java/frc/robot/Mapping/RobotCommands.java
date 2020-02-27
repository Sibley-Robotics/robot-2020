package frc.robot.Mapping;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Drivetrain.Drive;
import frc.robot.Subsystems.Collector;
import frc.robot.Subsystems.Shooter;


public class RobotCommands{

    public final static Drive m_robotDrive = new Drive();
    public final Shooter m_shooter = new Shooter();
    public final Collector m_collector = new Collector();



    // === Collector === //
    public final StartEndCommand groundEject = new StartEndCommand(
      //Sets the collector motor to reverse
        () -> m_collector.groundEject(0.5),
        () -> m_collector.groundEject(0),
        m_collector
    );
    public final StartEndCommand collectorReverse = new StartEndCommand (
      //Sets both the collector and conveyor motors to reverse
        () -> m_collector.collectorReverse(0.3, 0.4, 0.3),
        () -> m_collector.collectorReverse(0.0, 0.0, 0.0),
        m_collector
    );
    public final StartEndCommand groundCollect = new StartEndCommand (
      //Sets both the collector and conveyor motors to take in balls
        () -> m_collector.groundCollect(0.6, 0.8),
        () -> m_collector.groundCollect(0.0, 0.0),
        m_collector
    );
    public final StartEndCommand humanCollect = new StartEndCommand(
      //TODO: CHECK/ADJUST VALUES 
      () -> m_collector.humanCollect(0.6, 0.8),
      () -> m_collector.humanCollect(0.0, 0.0),
      m_collector
    );

    public final StartEndCommand reverseInjector = new StartEndCommand(
      () -> m_collector.reverseInjector(0.3),
      () -> m_collector.reverseInjector(0.0)

    );

    public final InstantCommand deployCollector = new InstantCommand(
        () -> m_collector.deployCollector()
    );
    public final InstantCommand retractCollector = new InstantCommand(
        () -> m_collector.retractCollector()
    );
    public final ConditionalCommand collector = new ConditionalCommand(retractCollector, deployCollector, Collector.isDeployedSupplier);


   // === Beam Breaks === //

    public final RunCommand beam = new RunCommand(
      () -> m_collector.lightCheck()
    );


    
    // === Shooter === //
    public final InstantCommand shooterFar = new InstantCommand(
        () -> m_shooter.shooterFar()

    );
    public final InstantCommand shooterNear = new InstantCommand(
        () -> m_shooter.shooterNear()

    );



    public final InstantCommand shooterRevUp = new InstantCommand(
      () -> m_shooter.shooterRev()

    );



    public final InstantCommand shooterStop = new InstantCommand(
      () -> m_shooter.shooterStop()

    );


    public final InstantCommand incrimentUp = new InstantCommand(
      () -> m_shooter.incrimentUp()

    );
    public final InstantCommand incrimentDown = new InstantCommand(
      () -> m_shooter.incrimentDown()

    );
 



   // public final ConditionalCommand shooterRevType = new ConditionalCommand(shooterRevFar, shooterRevClose, Shooter.isDeployedSupplier);

   // public final ConditionalCommand shooterRev = new ConditionalCommand(shooterStop, shooterRevType, Shooter.isOnSupplier);

  //  public final ConditionalCommand shoot = new ConditionalCommand(shooterStop, shooterNear, Shooter.isOnSupplier);

  public final ConditionalCommand shooterRev = new ConditionalCommand(
      shooterStop,
      shooterRevUp,
      Shooter.isOnSupplier

    );


  public final StartEndCommand shoot = new StartEndCommand(
    () -> m_shooter.shoot(), () -> m_shooter.shooterStop()
    );


    // === Climber === //

}

