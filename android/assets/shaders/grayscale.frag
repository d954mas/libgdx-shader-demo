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
        //uses NTSC conversion weights
        //dot скалярное произведение
        float gray = dot(texColor.rgb, vec3(0.299, 0.587, 0.114));
        vec3 grayscale = vec3(gray);
        gl_FragColor = vec4(grayscale, color.a);

}


