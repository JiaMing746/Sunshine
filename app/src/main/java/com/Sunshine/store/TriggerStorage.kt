package com.Sunshine.store

import android.content.Context
import com.Sunshine.common.shared.ObjectStorage
import com.Sunshine.model.TriggerInfo

class TriggerStorage(private val context: Context) : ObjectStorage<TriggerInfo>(context) {
    override public fun load(configFile: String): TriggerInfo? {
        return super.load(configFile)
    }

    public fun save(obj: TriggerInfo): Boolean {
        return super.save(obj, obj.id)
    }

    override public fun remove(configFile: String) {
        super.remove(configFile)
    }
}
