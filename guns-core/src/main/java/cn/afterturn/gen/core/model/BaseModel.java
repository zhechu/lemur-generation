/**
 * Copyright 2013-2017 JueYue (qrb.jueyue@gmail.com)
 *   
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.afterturn.gen.core.model;

import java.io.Serializable;

/**
 * 无业务的基础对象
 * @author JueYue
 * 2017年4月23日
 */
public class BaseModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BaseModel(String name) {
        this.name = name;
    }

    public BaseModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public BaseModel(String id, String key, String name) {
        this.id = id;
        this.key = key;
        this.name = name;
    }

    private String id;
    private String key;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
