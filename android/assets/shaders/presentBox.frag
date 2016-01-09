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
 uniform vec2 u_resolution;
 const vec3 color1=vec3(0.22, 0.275, 0.318);
 const vec3 color2=vec3(0.235, 0.286, 0.322);

void main() {
    vec4 color = texture2D(u_texture, v_texCoords);

        //vec2 p = (-u_resolution.xy+2.0*gl_FragColor.xy)/u_resolution.y;//центр экрана(возможно стоит потом поменять на цент текстуры чтобы можно было масштабировать
        vec2 p = (gl_FragCoord.xy / u_resolution.xy) - vec2(0.5);
        p.x *= u_resolution.x / u_resolution.y;
        // background
        vec2 q = vec2( atan(p.y,p.x), length(p));
        float f = smoothstep( -0.1, 0.1, sin(q.x*10.0 + u_time));//размытость в начале, затем размеры
        vec3 round_color = mix( color1, color2, f );



      vec3 col = vec3(0.0);
      float r = length(p)*10.0;
      float a = atan(p.y, p.x);
      col = mix(col, vec3(0.0), smoothstep(0.0, 4.0, r));
      col = mix(col, vec3(1.0), 1.0 - smoothstep(0.0, 1.0 + cos(u_time), r));

      col=mix(col,round_color,0.8);




     gl_FragColor = vec4(vec3(col), 1.0);
}


