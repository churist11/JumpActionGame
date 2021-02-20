package jp.techacademy.shoutarou.sakurai.jumpactiongame

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2

open class GameObject(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : Sprite(texture, srcX, srcY, srcWidth, srcHeight) {
    val velocity: Vector2  // x方向、y方向の速度を保持する

    init {
        velocity = Vector2()
    }
}