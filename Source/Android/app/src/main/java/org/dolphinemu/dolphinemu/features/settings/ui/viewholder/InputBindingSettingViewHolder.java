// SPDX-License-Identifier: GPL-2.0-or-later

package org.dolphinemu.dolphinemu.features.settings.ui.viewholder;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;

import org.dolphinemu.dolphinemu.R;
import org.dolphinemu.dolphinemu.features.settings.model.view.InputBindingSetting;
import org.dolphinemu.dolphinemu.features.settings.model.view.SettingsItem;
import org.dolphinemu.dolphinemu.features.settings.ui.SettingsAdapter;

public final class InputBindingSettingViewHolder extends SettingViewHolder
{
  private InputBindingSetting mItem;

  private TextView mTextSettingName;
  private TextView mTextSettingDescription;

  private Context mContext;

  public InputBindingSettingViewHolder(View itemView, SettingsAdapter adapter, Context context)
  {
    super(itemView, adapter);

    mContext = context;
  }

  @Override
  protected void findViews(View root)
  {
    mTextSettingName = root.findViewById(R.id.text_setting_name);
    mTextSettingDescription = root.findViewById(R.id.text_setting_description);
  }

  @Override
  public void bind(SettingsItem item)
  {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

    mItem = (InputBindingSetting) item;

    mTextSettingName.setText(mItem.getName());
    mTextSettingDescription
            .setText(sharedPreferences.getString(mItem.getKey() + mItem.getGameId(), ""));

    setStyle(mTextSettingName, mItem);
  }

  @Override
  public void onClick(View clicked)
  {
    if (!mItem.isEditable())
    {
      showNotRuntimeEditableError();
      return;
    }

    getAdapter().onInputBindingClick(mItem, getBindingAdapterPosition());

    setStyle(mTextSettingName, mItem);
  }

  @Nullable @Override
  protected SettingsItem getItem()
  {
    return mItem;
  }
}
