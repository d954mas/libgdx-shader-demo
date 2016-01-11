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
 const vec3 light_color=vec3(0.95, 0.355, 0.1);

 const float min_color_size=0.2;
 const float max_color_size=0.6;

void main() {
    vec4 color = texture2D(u_texture, v_texCoords);

       //vec2 p = (-u_resolution.xy+2.0*gl_FragColor.xy)/u_resolution.y;//центр экрана(возможно стоит потом поменять на цент текстуры чтобы можно было масштабировать
        vec2 p=vec2(v_texCoords.s,v_texCoords.t)-vec2(0.5);
        p.x *= u_resolution.x / u_resolution.y;
        // background
        vec2 q = vec2( -atan(p.y,p.x), length(p)); //-atan вращение в протмивоположную сторону
        float f = smoothstep( -0.1, 0.1, sin(q.x*10.0 + u_time));//размытость в начале, затем размеры
        vec3 round_color = mix( color1, color2, f );

      vec3 col = vec3(0.0);
      float r = length(p);
      float a = atan(p.y, p.x);
    //  col = mix(col, vec3(0), smoothstep(0.0, 4.0, r));
    //+0.05 чтобы при минимальной фазе края были чуть чуть размыты
    float maxvalue=min_color_size +(max_color_size-min_color_size)*(sin(u_time)+1.0)/2.0 +0.05;
      col = mix(col, light_color, 1.0 - smoothstep(min_color_size,maxvalue, r));

      col=mix(col,round_color,0.8);
      gl_FragColor = vec4(vec3(col), 1.0);


}



