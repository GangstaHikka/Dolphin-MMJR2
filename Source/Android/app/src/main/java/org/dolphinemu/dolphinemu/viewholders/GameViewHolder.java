// SPDX-License-Identifier: GPL-2.0-or-later

package org.dolphinemu.dolphinemu.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.dolphinemu.dolphinemu.R;
import org.dolphinemu.dolphinemu.model.GameFile;

import java.util.concurrent.CountedCompleter;

/**
 * A simple class that stores references to views so that the GameAdapter doesn't need to
 * keep calling findViewById(), which is expensive.
 */
public class GameViewHolder extends RecyclerView.ViewHolder
{
  public ImageView imageScreenshot;
  public TextView textGameTitle;
  public TextView textGameTitleInner;
  public TextView textGameCaption;
  public TextView textGameCountry;

  public GameFile gameFile;

    public GameViewHolder(View itemView)
  {
    super(itemView);

    itemView.setTag(this);

    imageScreenshot = itemView.findViewById(R.id.image_game_screen);
    textGameTitle = itemView.findViewById(R.id.text_game_title);
    textGameTitleInner = itemView.findViewById(R.id.text_game_title_inner);
    textGameCaption = itemView.findViewById(R.id.text_game_caption);
    textGameCountry = itemView.findViewById(R.id.text_country);
  }
}
