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
void main(){
    gl_FragColor = v_color * texture2D(u_texture, v_texCoords);
    gl_FragColor.a = abs(sin(u_time))*gl_FragColor.a;
    gl_FragColor.r = abs(cos(u_time))*gl_FragColor.r;
    gl_FragColor.g = abs(sin(u_time))*gl_FragColor.g;
    gl_FragColor.b = abs(cos(u_time))*gl_FragColor.b;
}