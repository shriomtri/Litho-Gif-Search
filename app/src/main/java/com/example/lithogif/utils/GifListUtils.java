package com.example.lithogif.utils;

import android.content.Context;

import androidx.annotation.Nullable;

import com.bumptech.glide.RequestManager;
import com.example.lithogif.components.GifItemView;
import com.example.lithogif.components.GifItemViewSpec;
import com.example.lithogif.models.GifItem;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.EventHandler;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.GridLayoutInfo;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.litho.widget.RenderInfo;

import java.util.ArrayList;
import java.util.List;

public class GifListUtils {
	public static void updateContent(ComponentContext c, RecyclerBinder binder, RequestManager glide,
									 List<GifItem> gifs, @Nullable GifItemViewSpec.GifCallback callback,
									 EventHandler likeEventHandler) {

		binder.removeRangeAt(0, binder.getItemCount());

		List<RenderInfo> components = new ArrayList<>();

		for (GifItem gif: gifs) {
			components.add(ComponentRenderInfo.create().component(
					GifItemView.create(c)
							.gif(gif)
							.glide(glide)
							.initLiked(gif.isLiked())
							.likeChangeEventHandler(likeEventHandler)
							.callback(callback)
							.key(gif.getId())
							.build()
				).build()
			);

		}

		binder.insertRangeAt(0, components);
	}

	public static RecyclerBinder getBinder(ComponentContext c, Context context) {
		return new RecyclerBinder.Builder().layoutInfo(new GridLayoutInfo(context, 2)).build(c);
	}
}
