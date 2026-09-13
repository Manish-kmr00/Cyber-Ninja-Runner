/// Clean strongly-typed audio events representing pure gameplay and UI intents.
///
/// Decouples gameplay logic from physical sound files and audio player mechanics.
/// Named [GameAudioEvent] to prevent collision with audioplayers' internal AudioEvent.
enum GameAudioEvent {
  // --- PLAYER ---
  playerJump,
  playerLand,
  playerWallJump,
  playerSlide,
  playerDamage,
  playerDeath,

  // --- COMBAT ---
  attack,
  hit,
  criticalHit,
  explosion,
  projectile,
  weaponFire,

  // --- ENEMY ---
  enemySpawn,
  enemyAttack,
  enemyHit,
  enemyDeath,

  // --- WORLD & ENVIRONMENT ---
  checkpoint,
  collect,
  powerup,
  shield,
  booster,

  // --- UI ---
  buttonClick,
  buttonHover,
  menuOpen,
  menuClose,
  purchase,
  notification,
  error,

  // --- GAME STATE ---
  gameStart,
  gameOver,
  levelComplete,
  pause,
  resume,
}
