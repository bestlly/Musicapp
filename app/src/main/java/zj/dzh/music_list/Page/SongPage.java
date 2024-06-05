package zj.dzh.music_list.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import zj.dzh.music_list.Music.MusicActivity;
import zj.dzh.music_list.R;

public class SongPage extends Fragment {
    //声明视图变量view
    private View view;
    //在这里添加歌曲名
    public String[] name={"周杰伦——你听得到","周杰伦——七里香","陶喆——普通朋友","周杰伦——手写的从前","周杰伦——星晴",
                          "陈奕迅——爱情转移","周杰伦——最长的电影","周杰伦—蒲公英的约定","周杰伦——你怎么连话都说不清楚","周杰伦——蒲公英的约定",
                          "周杰伦——青花瓷","周杰伦——爱情废柴","周杰伦——晴天","周杰伦——爱在西元前","周杰伦——安静",
                          "周杰伦——暗号","周杰伦——手语","周杰伦——半岛铁盒","周杰伦——说好的幸福呢","周杰伦——不能说的秘密",
                          "周杰伦——雨下一整晚","周杰伦——错过的烟火","周杰伦——大笨钟","周杰伦——退后","周杰伦——倒影",
                          "周杰伦——稻香","周杰伦——等你下课","周杰伦——断了的弦","周杰伦——发如雪","周杰伦——反方向的钟",
                          "周杰伦——粉色海洋","周杰伦——枫","周杰伦——以父之名","周杰伦——搁浅","周杰伦——给我一首歌的时间",
                          "周杰伦——轨迹","周杰伦——还在流浪","周杰伦——烟花易冷","周杰伦——红尘客栈","周杰伦——红颜如霜",
                          "周杰伦——花海","周杰伦——回到过去","周杰伦——简单爱","周杰伦——借口","周杰伦——一路向北",
                          "周杰伦——开不了口","周杰伦——可爱女人","周杰伦——明明就","周杰伦——我是如此相信","周杰伦——浪漫手机",
                          "周杰伦——龙卷风","周杰伦——美人鱼","周杰伦——夜曲","周杰伦——我落泪情绪零碎"};
    //在这里添加歌曲图片
    public static int[] icons={R.drawable.music5,R.drawable.music5,R.drawable.music5,
    R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,
            R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,
            R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,
            R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,
            R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5,R.drawable.music5};
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.music_list,null);
        //1、创建并绑定列表
        ListView listView = view.findViewById(R.id.lv);
        //2、创建适配器对象
        MyBaseAdapter adapter = new MyBaseAdapter();
        //3、给列表设置适配器
        listView.setAdapter(adapter);
        //设置列表条目监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //创建Intent对象，启动音乐播放界面
                Intent intent = new Intent(SongPage.this.getContext(), MusicActivity.class);
                //将数据存入Intent对象，利用键值对
                intent.putExtra("name", name[position]);
                intent.putExtra("position", String.valueOf(position));
                //开启意图，进行跳转
                startActivity(intent);
            }
        });
        return view;
    }

    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){return  name.length;}
        @Override
        public Object getItem(int i){return name[i];}
        @Override
        public long getItemId(int i){return i;}

        @Override
        public View getView(int i ,View convertView, ViewGroup parent) {
            //绑定视图，并且显示歌曲名和歌曲图片
            View view = View.inflate(SongPage.this.getContext(), R.layout.item_music, null);
            TextView songName = view.findViewById(R.id.song_name);
            ImageView songPic = view.findViewById(R.id.song_pic);
            songName.setText(name[i]);
            songPic.setImageResource(icons[i]);
            return view;
        }
    }


}
