package jp.techacademy.shoutarou.sakurai.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Enemy(type: Int, texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object {
        // 横幅、高さ
        val ENEMY_WIDTH = 1.0f
        val ENEMY_HEIGHT = 1.0f

        // タイプ（通常と動くタイプ）
        val ENEMY_TYPE_STATIC = 0
        val ENEMY_TYPE_MOVING = 1

        // 状態（通常と消えた状態）
        val ENEMY_STATE_NORMAL = 0
        val ENEMY_STATE_VANISH = 1

        // 速度
        val ENEMY_VELOCITY = 2.0f
    }

    var mState: Int = 0
    var mType: Int

    init {
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT)
        mType = type
        if (mType == ENEMY_TYPE_MOVING) {
            velocity.x = ENEMY_VELOCITY
        }
    }

    // 座標を更新する
    fun update(deltaTime: Float) {
        if (mType == ENEMY_TYPE_MOVING) {
            x += velocity.x * deltaTime

            if (x < ENEMY_WIDTH / 2) {
                velocity.x = -velocity.x
                x = ENEMY_WIDTH / 2
            }
            if (x > GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2) {
                velocity.x = -velocity.x
                x = GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2
            }
        }
    }

    // 消える
    fun vanish() {
        mState = ENEMY_STATE_VANISH
        setAlpha(0f)
        velocity.x = 0f
    }
}