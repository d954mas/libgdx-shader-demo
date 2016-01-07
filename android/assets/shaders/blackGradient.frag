#ifdef GL_ES
     #define LOWP lowp
     precision mediump float;
 #else
     #define LOWP
 #endif

 varying LOWP vec4 v_color;
 varying vec2 v_texCoords;
 uniform sampler2D u_texture;
 uniform float u_time;

void main() {
        vec4 color = texture2D(u_texture, v_texCoords);
        gl_FragColor = vec4(vec3(v_texCoords.s), 1.0);
}